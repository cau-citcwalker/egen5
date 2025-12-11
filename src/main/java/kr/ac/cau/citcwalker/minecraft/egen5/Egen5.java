package kr.ac.cau.citcwalker.minecraft.egen5;

import kr.ac.cau.citcwalker.minecraft.egen5.discord.Commands;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Egen5 extends JavaPlugin {

    private JDA jda;
    private EmbedBuilder embed = new EmbedBuilder();

    @Override
    public void onEnable() {
        // Plugin startup logic
        jda = JDABuilder.createDefault(Datas.token).enableIntents(GatewayIntent.MESSAGE_CONTENT).enableIntents(GatewayIntent.GUILD_MEMBERS).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.addEventListener(new Commands());
        jda.getGuildById(Datas.guildID).getTextChannelById(Datas.channelID).sendMessageEmbeds(embed.setTitle("서버 켜짐").setColor(0x00ff00).setDescription("The Server is online.\nServer ip : 25.32.194.9:25565").build()).queue();
        embed.clear();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        jda.getGuildById(Datas.guildID).getTextChannelById(Datas.channelID).sendMessageEmbeds(embed.setTitle("서버 꺼짐").setColor(0xff0000).setDescription("The Server is offline").build()).queue();
        embed.clear();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return false;
    }
}
