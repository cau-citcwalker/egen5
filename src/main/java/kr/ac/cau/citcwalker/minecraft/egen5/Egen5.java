package kr.ac.cau.citcwalker.minecraft.egen5;

import kr.ac.cau.citcwalker.minecraft.egen5.discord.Commands;
import kr.ac.cau.citcwalker.minecraft.egen5.item.ReturnSkul;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.EventListener;

public final class Egen5 extends JavaPlugin implements Listener {

    private JDA jda;
    private EmbedBuilder embed = new EmbedBuilder();
    private ReturnSkul returnSkul;

    @Override
    public void onEnable() {
        // Plugin startup logic
        jda = JDABuilder.createDefault(Datas.token).enableIntents(GatewayIntent.MESSAGE_CONTENT).enableIntents(GatewayIntent.GUILD_MEMBERS).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.addEventListener(new Commands());
        jda.getGuildById(Datas.guildID).getTextChannelById(Datas.channelID).sendMessageEmbeds(embed.setTitle("서버 켜짐").setColor(0x00ff00).setDescription("The Server is online.\nServer ip : 25.32.194.9:25565").build()).queue();
        embed.clear();

        //Enable Event Handler
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        jda.getGuildById(Datas.guildID).getTextChannelById(Datas.channelID).sendMessageEmbeds(embed.setTitle("서버 꺼짐").setColor(0xff0000).setDescription("The Server is offline").build()).queue();
        embed.clear();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("returnskul") && sender instanceof Player) {
            ((Player) sender).getInventory().addItem(returnSkul);
        }
        return false;
    }

    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if ( action.equals( Action.RIGHT_CLICK_AIR ) || action.equals( Action.RIGHT_CLICK_BLOCK ) ) {
            if ( item != null && item == returnSkul ) {
                player.performCommand("/home home");
                ItemStack hand =  player.getInventory().getItemInMainHand();
                if(hand.getAmount() == 1) {
                    player.getInventory().setItemInMainHand(null);
                }else {
                    hand.setAmount(hand.getAmount() - 1);
                }
            }
        }

    }
}
