package hwCode;


//class that represents a Block with its dimension (length, width, height)
public class BlockRep implements Comparable<BlockRep>{ 
    
	//block dimensions
	int length;
    int width;
    int height;
    int base; 
      
    //initialize variable
    public BlockRep(int l, int w, int h) { 
        length = l; 
        width = w; 
        height = h; 
        
        base = length * width;
    } 
      
    
    
    //for sorting based on base area
    public int compareTo(BlockRep b) { 
        return b.base-this.base; 
    }
    
    public String toString() {
    	return length + " " + width + " " + height;
    }
} 