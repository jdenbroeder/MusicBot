/*
 * Copyright 2016 John Grosh <john.a.grosh@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jagrosh.jmusicbot.commands.music;

import com.jagrosh.jmusicbot.Bot;
import com.jagrosh.jmusicbot.audio.AudioHandler;
import com.jagrosh.jmusicbot.audio.QueuedTrack;
import com.jagrosh.jmusicbot.commands.music.PlayCmd;

/**
 *
 * @author John Grosh <john.a.grosh@gmail.com>
 */
public class FairPlayCmd extends PlayCmd
{
    public FairPlayCmd(Bot bot)
    {
        super(bot);
        this.name = "fairplay";
        this.arguments = "<title|URL|subcommand>";
        this.help = "plays the provided song, but queues it ahead in a round-robin order";
        this.aliases = bot.getConfig().getAliases(this.name);
    }

    @Override
    protected int addTrack(AudioHandler handler, QueuedTrack track)
    {
		return handler.addFairTrack(track);
    }
}
