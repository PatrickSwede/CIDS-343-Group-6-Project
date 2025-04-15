package map;

public class Chunk {
    private int[][] chunkMap;
    private boolean activeChunk;
    public Chunk(int[][] thingy, boolean active){
        this.chunkMap = thingy;
        this.activeChunk = active;
    }
}

