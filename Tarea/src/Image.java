import java.awt.List;
import java.util.ArrayList;


public class Image {

	static ArrayList<Pixel> pixels = new ArrayList<Pixel>();
	static ArrayList<Pixel> pixelsTemp = new ArrayList<Pixel>();
	//Pixel[][] pixelMatrix = new Pixel[11][11]; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image mona = new Image();
//		int[][] temp = mona.buildMatrix();
//		mona.pixelMatrix = mona.buildPixelMatrix(temp);
//		mona.printArrayMatrix();
//		mona.getBoundary();
		
		//int[][] tempVecinos = mona.buildMatrixExcercise2();
		//Pixel[][] pixelMatrixExcercise2 = new Pixel[11][11];
		//pixelMatrixExcercise2 = mona.buildPixelMatrix(tempVecinos);
		//mona.countOnes(pixelMatrixExcercise2);
		//mona.distingueVecindario(pixelMatrixExcercise2);
		
		int[][] tempMatrix = mona.buildMatrixExcercise5();
		Pixel[][] pixelMatrixExcercise5 = new Pixel[10][10];
		pixelMatrixExcercise5 = mona.buildPixelMatrix(tempMatrix);
		Pixel[][] lolaSkinny = mona.erosioname(pixelMatrixExcercise5);
		Pixel[][] lolaFat = mona.engordador(lolaSkinny);
		System.out.println(mona.cuentaPalitosVecinos(lolaFat));
		System.out.println(mona.cuentaTetraPitzel(lolaFat));
		System.out.println(mona.cuentaObjetos(lolaFat));
		System.out.println(mona.cuentaObjetos(pixelMatrixExcercise5));
	}

	public Pixel[][] buildPixelMatrix(int[][] matrix){
		Pixel[][] pixelMat = new Pixel[11][11];
		Pixel temp= null;
		int count=0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				int value= matrix[i][j];
				Pixel currentPixel= new Pixel(value,i,j);
				currentPixel.actualizaVecinos(pixels);
				count++;
				//System.out.println(count +" "+ currentPixel.value);
				pixels.add(currentPixel);
				pixelMat[i][j]= currentPixel;
			}
		}
		return pixelMat;
	}
	
	public int[][] buildMatrix(){
		int array[][]= {{0,0,0,0,0,0,0,0,0,0,0},
		                {0,0,1,1,1,1,1,1,1,0,0},
		                {0,0,1,1,1,1,1,1,1,0,0},
		                {0,0,1,1,0,0,0,1,1,0,0},
		                {0,0,1,1,0,0,0,1,1,0,0},
		                {0,1,1,1,1,1,1,1,1,1,0},
		                {0,1,1,1,1,1,1,1,1,1,0},
		                {0,0,0,1,1,1,1,1,0,0,0},
		                {0,0,0,1,1,1,1,1,0,0,0},
		                {0,0,0,0,0,0,0,0,0,0,0},
		                {0,0,0,0,0,0,0,0,0,0,0}};
		return array;
	}
	
	public int[][] buildMatrixExcercise2(){
		int array[][]= {{0,0,0,0,0,0,0,0,0,0,0},
		                {0,0,1,1,1,1,1,1,1,0,0},
		                {0,0,1,1,1,1,1,1,1,0,0},
		                {0,0,1,1,0,0,0,1,1,0,0},
		                {0,0,1,1,0,0,0,1,1,0,0},
		                {0,1,1,1,1,1,1,1,1,1,0},
		                {0,1,1,1,1,1,1,1,1,1,0},
		                {0,0,0,0,0,0,0,0,0,0,0},
		                {0,0,0,1,1,1,1,1,0,0,0},
		                {0,0,0,1,1,1,1,1,0,0,0},
		                {0,0,0,0,0,0,0,0,0,0,0}};
		return array;
	}

	public int[][] buildMatrixExcercise5(){
		int array[][]= {{0,0,0,0,0,0,0,0,0,0},
						{0,1,1,1,0,0,0,0,0,0},
						{0,1,1,1,0,0,0,0,0,0},
						{0,1,1,1,0,0,0,0,0,0},
						{0,0,0,1,1,0,0,0,0,0},
						{0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,1,1,1,1,1,0},
						{0,0,0,0,0,0,1,1,1,0},
						{0,0,0,0,0,0,1,1,1,0},
		                {0,0,0,0,0,0,0,0,0,0}};
		return array;
	}
	
	public void printArray(){
		int count=0;
		for(Pixel temp : pixels){
			System.out.print(temp.value + ".");
			count++;
			if(count == 10){
				System.out.println("");
				count=0;
			}
		}
	}
	
	public void printArrayMatrix(Pixel[][] pixelMatrix){
		for(int i=0; i<pixelMatrix.length; i++){
			//System.out.print(" i "+i);
			for(int j=0; j<pixelMatrix[i].length; j++){
				//System.out.print(" i "+i+" j "+j);
				Pixel currentPixel= pixelMatrix[i][j];
				if(currentPixel!= null){
					System.out.print(currentPixel.value + " ");
				}
			}
			System.out.println(" ");
		}
	}

	public Pixel getFirstPixel(Pixel[][] pixelMatrix){
		for(int i=0; i<pixelMatrix.length; i++){
			for(int j=0; j<pixelMatrix[i].length; j++){
				//System.out.println("a "+i + " " +j);
				if(pixelMatrix[i][j].value==1){
					return pixelMatrix[i][j];
				}
			}
		}
		return null;
	}
	
	public void getBoundary(Pixel[][] pixelMatrix){
		Pixel start = getFirstPixel(pixelMatrix);
		//System.out.println("f "+start.x + " " +start.y);
		start.isBoundary=true;
		start.startPixel=true;
		this.getNextBundaryFriend(start);
		
		this.printBoundaryMatrix(pixelMatrix);
	}
	
	public void getNextBundaryFriend(Pixel pixel){
		//System.out.println("bf "+pixel.x + " " +pixel.y);
		Pixel vecino = pixel.getVecinoClock();
		if(vecino != null ){
			pixel.isBoundary=true;
			//System.out.println("bpixel "+pixel.x+","+pixel.y);
			if(vecino.startPixel){
				return;
			}
			this.getNextBundaryFriend(vecino);
		}
	}
	
	public void printBoundaryMatrix(Pixel[][] pixelMatrix){
		System.out.println(" ");
		for(int i=0; i<pixelMatrix.length; i++){
			for(int j=0; j<pixelMatrix[i].length; j++){
				if(pixelMatrix[i][j].isBoundary){
					System.out.print(1 + " ");
				}else{
					System.out.print(0 + " ");
				}
			}
			System.out.println("");
		}
	}
	
	public void printMatrixRellenada(Pixel [][] mona){
		System.out.println(" ");
		for(int i=0; i<mona.length; i++){
			for(int j=0; j<mona[i].length; j++){
				System.out.print(mona[i][j].value + " ");
			}
			System.out.println("");
		}
	}
	
	public void rellenaCuates(int orig, int repla, Pixel pix){//floodFill
		if(pix == null){
			return;
		}
		if(pix.value == orig){
			pix.value=repla;
		}else{
			return;
		}
		rellenaCuates(orig,repla, pix.vecinitos[0]);
		rellenaCuates(orig,repla, pix.vecinitos[2]);
		rellenaCuates(orig,repla, pix.vecinitos[4]);
		rellenaCuates(orig,repla, pix.vecinitos[6]);
	}
	
	public void distingueVecindario(Pixel[][] pixelsMatrix){//simple conectado y multiple conectado
		Pixel startPixel = pixelsMatrix[0][0];
		rellenaCuates(0,8,startPixel);
		buscaMultipleConectados();
		buscaSimpleConectados();
		rellenaCuates(8,0,startPixel);
		
		printMatrixRellenada(pixelsMatrix);
	}
	
	public void buscaMultipleConectados(){
		for(Pixel tempPixel : this.pixels){
			if(tempPixel.value==0){
				Pixel one = tempPixel.getTheOne();
				if(one != null){
					rellenaCuates(1,3,one);
				}
			}
		}
	}
	
	public void buscaSimpleConectados(){
		for(Pixel tempPixel : this.pixels){
			if(tempPixel.value==1){
				rellenaCuates(1,2,tempPixel);
			}
		}
	}
	
	public void countOnes(Pixel [][] matrix){	
		int[]cols = new int[matrix.length];
		int[]rows = new int[matrix.length];
		
		for(int i=0; i<matrix.length; i++){
			int tempRow=0;
			for(int j=0; j<matrix[i].length; j++){
				Pixel tempPix = matrix[i][j];
				tempRow = tempRow+tempPix.value;
				rows[j] = rows[j]+tempPix.value;
				System.out.print(tempPix.value +" ");
				if(j+1 == matrix[j].length){
					System.out.print(tempRow);
				}
			}
			System.out.println("");
		}
		for(int w=0; w<rows.length; w++){
			System.out.print(rows[w]+" ");
		}
		
	}
	
	public Pixel [][] erosioname(Pixel [][] matrix){
		Pixel [][] tempMatrix = new Pixel[matrix.length][matrix.length];		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j]==null){
					break;
				}
				Pixel tempPix = new Pixel(matrix[i][j].value,matrix[i][j].x,matrix[i][j].y);
				tempPix.actualizaVecinos(pixelsTemp);
				pixelsTemp.add(tempPix);
				tempMatrix[i][j]= tempPix;

				if(tempPix.value==1){
					if(respetaPattern(matrix[i][j])){
						tempPix.value=1;
					}else{
						tempPix.value=0;
					}
				}
			}
		}
		this.printArrayMatrix(tempMatrix);
		return tempMatrix;
	}
	
	public boolean respetaPattern(Pixel pixel){
		if(pixel.vecinitos[0].value == 1 &&  pixel.vecinitos[2].value == 1 && pixel.vecinitos[4].value ==1 && pixel.vecinitos[6].value ==1){
			return true;
		}
		return false;
	}
	
	public void llenaPattern(Pixel pixel, Pixel[][] meitrix){
		this.validaVecinito(pixel, 0, pixel.x-1, pixel.y,meitrix);
		this.validaVecinito(pixel, 2, pixel.x, pixel.y-1,meitrix);
		this.validaVecinito(pixel, 4, pixel.x+1, pixel.y,meitrix);
		this.validaVecinito(pixel, 6, pixel.x, pixel.y+1,meitrix);
	}
	
	public void validaVecinito(Pixel pixel, int index, int x, int y, Pixel[][]meitrix){
		if(pixel.vecinitos[index] != null){
			pixel.vecinitos[index].value = 1;
		}else{
			Pixel temp = new Pixel(1,x,y);
			meitrix[x][y]=temp;
			pixel.vecinitos[index]= temp;
			pixelsTemp.add(temp);
		}
	}
	
	public Pixel[][] engordador(Pixel [][] matrix){//Dilatador
		pixelsTemp.clear();
		Pixel [][] tempMatrix = new Pixel[matrix.length][matrix.length];		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j]==null){
					break;
				}
				if(tempMatrix[i][j] == null){
					Pixel tempPix = new Pixel(matrix[i][j].value,matrix[i][j].x,matrix[i][j].y);
					tempPix.actualizaVecinos(pixelsTemp);
					pixelsTemp.add(tempPix);
					tempMatrix[i][j]= tempPix;
				}
				if(matrix[i][j].value==1){
					llenaPattern(tempMatrix[i][j], tempMatrix);
				}
			}
		}
		this.printArrayMatrix(tempMatrix);
		return tempMatrix;
	}

	public int cuentaPalitosVecinos(Pixel [][] matrix){
		int count=0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j] != null && matrix[i][j].value==1){
					if(matrix[i+1][j] != null && matrix[i+1][j].value == 1){
						count++;
					}
					if(matrix[i][j+1] != null && matrix[i][j+1].value == 1){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public int cuentaTetraPitzel(Pixel [][] matrix){
		int count=0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j] != null && matrix[i][j].value==1){
					if(soyTetraPitzel(matrix[i][j])){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public boolean soyTetraPitzel(Pixel pix){
		try{
			if(pix.vecinitos[4].value != 1){
				return false;
			}
			if(pix.vecinitos[5].value != 1){
				return false;
			}
			if(pix.vecinitos[6].value != 1){
				return false;
			}
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public int cuentaOnes(Pixel [][] matrix){
		int count=0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j] != null && matrix[i][j].value== 1){
					count ++;
				}
			}
		}
		return count;
	}
	
	public int cuentaObjetos(Pixel [][] matrix){
		int palitos = this.cuentaPalitosVecinos(matrix);
		int tetrapixel = this.cuentaTetraPitzel(matrix);
		int ones = this.cuentaOnes(matrix);
		return ones+tetrapixel -palitos;
	}
}

