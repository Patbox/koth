package io.github.restioson.koth.game.map;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import xyz.nucleoid.plasmid.map.template.MapTemplate;
import xyz.nucleoid.plasmid.map.template.TemplateChunkGenerator;
import xyz.nucleoid.plasmid.util.BlockBounds;

public class KothMap {
    private final MapTemplate template;
    public final BlockBounds spawn;
    public final int spawnAngle;
    public final BlockBounds bounds;
    public final BlockBounds noPvp;
    public final BlockBounds throne;

    public KothMap(MapTemplate template, BlockBounds spawn, BlockBounds throne, int spawnAngle) {
        this.template = template;
        this.spawn = spawn;
        this.spawnAngle = spawnAngle;
        this.bounds = template.getBounds();
        this.throne = throne;

        BlockPos max = this.spawn.getMax();
        this.noPvp = new BlockBounds(this.spawn.getMin(), new BlockPos(max.getX(), max.getY() + 3, max.getZ()));
    }

    public ChunkGenerator asGenerator(MinecraftServer server) {
        return new TemplateChunkGenerator(server, this.template);
    }
}
