package kr.ac.cau.citcwalker.minecraft.egen5.discord;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.isFromGuild()) {
            //Guild Message
        }
    }
}
