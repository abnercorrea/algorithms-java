public static byte setBit(byte b, int i) {
    // CAUTION !! the OR, AND, XOR, >>, << operators return Integer for byte input... 
    // needs to CAST result to byte
    return (byte) ((1 << i) | b);
}

public static void drawPixel(byte[] screen, int width, int x, int y) {
    int lineSize = width / 8;
    int pixelByte = (y * lineSize) + (x / 8);     
    int byteX = x % 8;
    
    screen[pixelByte] = setBit(screen[pixelByte], byteX);
}

// CAUTION!!! if not using unsigned bytes, representaion will be in complement of 2 (7th bit is signal)
public static void drawHorizontalLine(byte[] screen, int width, int x1, int x2, int y) {
    if (screen == null || width <= 0 || x1 < 0 || x2 < 0 || x1 >= width || x2 >= width ) return;
    
    int height = (screen.length * 8) / width;
    
    if (height < 1 || y >= height) return;
    
    for (int x = x1; x <= x2; x++)
        drawPixel(screen, width, x, y);
}


// test
byte[][] screen = { { 0, 5, 1, 1, 0, 0, 5, 0 } }
byte[][] result = { { 0, 5, 1, 1, -1, -1, 5, 0 } }

drawHorizontalLine(screen[0], 16, 0, 15, 2)

Arrays.equals(screen[0], result[0])

// debug
screen = { 0, 5, 1, 1, 0, 0, 5, 0 }, { 0, 5, 1, 1, 1, 0, 5, 0 }
width = 16
x1 = 0
x2 = 15
y = 2
height = 4
x = 0
lineSize = 2
pixelByte = 4
byteX = 0
OK

/*
width is in pixels


*/