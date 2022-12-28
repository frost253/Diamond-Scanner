package commandspackage;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.*;

public class Scan implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Player player = (Player) sender;

        if (player.isFlying()) {
            player.sendMessage(ChatColor.RED + "Stop flying to use this command");
        }

        //gets player's coordinates
        int playerX = player.getLocation().getBlockX();
        int playerY = player.getLocation().getBlockX();
        int playerZ = player.getLocation().getBlockX();

        //get player's chunk
        Chunk chunk = player.getLocation().getChunk();
        ChunkSnapshot snapshot = chunk.getChunkSnapshot();

        final int chunkSize = 16;

        //scans player's chunk for diamond ore
        for (int x=0; x<chunkSize; x++) {
            for (int z=0; z<chunkSize; z++) {
                for (int y = 255; y > 0; y--) {
                    Block block = chunk.getBlock(x, y, z);
                    if (block.getType() == Material.DIAMOND_ORE) {
                        player.sendMessage(ChatColor.BLUE + "There is diamond at " + block.getX()
                                    + " " + block.getY() + " " + block.getZ());
                    }
                }
            }
        }
        return true;
    }
}
