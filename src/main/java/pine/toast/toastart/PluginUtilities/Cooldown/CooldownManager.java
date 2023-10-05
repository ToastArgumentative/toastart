package pine.toast.toastart.PluginUtilities.Cooldown;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {
    private Map<UUID, Map<String, Long>> userCooldowns = new HashMap<>();
    private final int MILLISECONDS_PER_SECOND = 1000;

    public boolean isOnCooldown(UUID userId, String abilityName) {
        Map<String, Long> userAbilities = userCooldowns.get(userId);
        if (userAbilities != null) {
            Long cooldownExpirationTime = userAbilities.get(abilityName);
            if (cooldownExpirationTime != null && cooldownExpirationTime > System.currentTimeMillis()) {
                return true; // The ability is on cooldown
            }
        }
        return false; // The ability is not on cooldown
    }

    public void putOnCooldown(UUID userId, String abilityName, int cooldownSeconds) {
        Map<String, Long> userAbilities = userCooldowns.computeIfAbsent(userId, k -> new HashMap<>());
        long cooldownExpirationTime = System.currentTimeMillis() + cooldownSeconds * MILLISECONDS_PER_SECOND;
        userAbilities.put(abilityName, cooldownExpirationTime);
    }

    public long getRemainingCooldownSeconds(UUID userId, String abilityName) {
        Map<String, Long> userAbilities = userCooldowns.get(userId);
        if (userAbilities != null) {
            Long cooldownExpirationTime = userAbilities.get(abilityName);
            if (cooldownExpirationTime != null) {
                long currentTime = System.currentTimeMillis();
                if (cooldownExpirationTime > currentTime) {
                    long remainingMillis = cooldownExpirationTime - currentTime;
                    return remainingMillis / MILLISECONDS_PER_SECOND;
                }
            }
        }
        return 0; // The ability is either not on cooldown or cooldown has already expired
    }
}




