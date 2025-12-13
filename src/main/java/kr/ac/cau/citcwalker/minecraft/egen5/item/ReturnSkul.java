package kr.ac.cau.citcwalker.minecraft.egen5.item;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ReturnSkul extends ItemStack {
    private ItemMeta meta;
    private List<String> lore;
    public ReturnSkul() {
        super(Material.PAPER);
        meta.setItemName("§b귀환석");
        lore.add("§7집으로 돌아갈 수 있는 귀환석이다.");
        lore.add("§7누군진 모르겠는데 윤현이 만들어달라고 했다.");
        lore.add("§7사유는 잘 모르겠는데 sethome을 넣어도 /home을 치기 귀찮으시댄다.");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.PROTECTION, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        setItemMeta(meta);
    }
}
