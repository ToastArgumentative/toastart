package pine.toast.toastart.PluginUtilities;

public enum InventorySlot {
    HELMET(5),
    CHESTPLATE(6),
    LEGGINGS(7),
    BOOTS(8),
    OFF_HAND(45),
    FIRST_ROW_FIRST_SLOT(9),
    FIRST_ROW_LAST_SLOT(17),
    SECOND_ROW_FIRST_SLOT(18),
    SECOND_ROW_LAST_SLOT(26),
    THIRD_ROW_FIRST_SLOT(27),
    THIRD_ROW_LAST_SLOT(35),
    HOTBAR_FIRST_SLOT(36),
    HOTBAR_LAST_SLOT(44);

    private final int slotId;

    InventorySlot(int slotId) {
        this.slotId = slotId;
    }

    public int getSlotId() {
        return slotId;
    }
}

