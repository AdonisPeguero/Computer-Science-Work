//peguenoa@kean.edu class#: CPS2231-03. 
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
public class Program8{
	static int width,height;
	static int size;
	static double cx, cy;
public static void main(String[] args){
	try{
		BufferedImage image = null;
		URL url=new URL("http://eve.kean.edu/~chuang/program8.png");
		image = ImageIO.read(url);
		height=image.getHeight();
		width=image.getWidth();
		System.out.println("width:"+width+" height:"+height);
		
		int [][] img=new int[height][width];
		
		for (int y=0;y<height;y++)
			for (int x=0;x<width;x++)
				img[y][x]=image.getData().getSample(x, y, 0);
		
		printImg(img);
		
		int color=2;
		for (int y=0;y<height;y++){
			for (int x=0;x<width;x++){
				if (img[y][x]==0){
					size=0;
					cx=0; cy=0;
					label(img, x,y,color);
					System.out.println("Color "+color+" object Size:" + size+ " center at:"+ cx/size+","+cy/size);
					color++;
				}
			}
		}
		
		System.out.println("Total number of black objects:"+(color-2));
		printImg(img);
	
}catch (IOException e) {e.printStackTrace();}
}

static void label(int[][] A, int x, int y, int color){
	if ((x>=0) && (y>=0) && (x<width) && (y<height) && (A[y][x]==0)){
		System.out.printf("(%d,%d) color:%d/n",x,y,color);
		A[y][x]=color;
		size++;
		cx=cx+x;
		cy=cy+y;
		label(A,x,y-1,color);
		label(A,x-1,y,color);
		label(A,x,y+1,color);
		label(A, x+1, y,color);
	}
}

static void printImg(int[][] A){
	for (int y=0;y<height;y++){
		for (int x=0;x<width;x++)
			System.out.printf("%d",A[y][x]);
		System.out.println();
	}
}
}