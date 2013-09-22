import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.imageio.ImageIO;
import javax.swing.table.TableModel;

import net.sf.image4j.codec.bmp.BMPDecoder;


public class Image {

	static ArrayList<Pixel> pixels = new ArrayList<Pixel>();
	static ArrayList<Pixel> pixelsTemp = new ArrayList<Pixel>();
	Pixel [][] publicMatrix = null;
	
	ArrayList<Integer> valuesSingle = new ArrayList<Integer>();
	
	public Image (){
		
	}

	public Pixel[][] buildPixelMatrix(int[][] matrix){
		Pixel[][] pixelMat = new Pixel[11][11];
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				int value= matrix[i][j];
				Pixel currentPixel= new Pixel(value,i,j);
				currentPixel.actualizaVecinos(pixels,pixelMat);
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
	
	public Pixel[][] changeTableModelToPixelMatrix(TableModel table){
		Pixel[][] pixelMat = new Pixel[table.getColumnCount()][table.getRowCount()];
		pixels.clear();
		for (int x =0; x<table.getColumnCount(); x++){
			for (int y=0; y<table.getRowCount(); y++){
				int value=0;
				try{value= (int)table.getValueAt(y,x);
				}catch(Exception e){ continue; }
				System.out.print(value +" ");
				Pixel currentPixel = new Pixel(value, x, y);
				currentPixel.actualizaVecinos(pixels,pixelMat);
				pixels.add(currentPixel);
				pixelMat[x][y]= currentPixel;
			}
			System.out.println(" ");
		}
		this.publicMatrix = pixelMat;
		return pixelMat;
	}
	
	public int get8count(Pixel temp){
		int count=0;
		for(Pixel pix : temp.vecinitos){
			if(pix != null){
			count += pix.value;
			}
		}
		return count;
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
	
	public void printArrayMatrix(Pixel[][] pixelMatrix, TableModel matrix){
		for(int i=0; i<pixelMatrix.length; i++){
			//System.out.print(" i "+i);
			for(int j=0; j<pixelMatrix[i].length; j++){
				//System.out.print(" i "+i+" j "+j);
				Pixel currentPixel= pixelMatrix[i][j];
				if(currentPixel!= null){
					matrix.setValueAt(currentPixel.value, i, j);
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
		//System.out.println("Boundary f "+start.x + " " +start.y);
		start.isBoundary=true;
		start.startPixel=true;
		this.getNextBundaryFriend(start);
		this.publicMatrix =  pixelMatrix;
		//this.printBoundaryMatrix(pixelMatrix);
	}

	public void getNextBundaryFriend(Pixel pixel){
		//System.out.println("bf "+pixel.x + " " +pixel.y);
		Pixel vecino = pixel.getVecinoClock();
		if(vecino != null ){
			//System.out.println(pixel.x+","+pixel.y+ " v "+vecino.x+","+vecino.y);
			pixel.isBoundary=true;
			//System.out.println("bpixel "+pixel.x+","+pixel.y);
			if(vecino.startPixel){
				return;
			}
			this.getNextBundaryFriend(vecino);
		}
	}
	
	public TableModel printBoundaryMatrix(Pixel[][] pixelMatrix ,TableModel matrix){
		System.out.println(" ");
		for(int x=0; x<pixelMatrix.length; x++){
			for(int y=0; y<pixelMatrix[x].length; y++){
				if(pixelMatrix[x][y].isBoundary){
					matrix.setValueAt(1, y, x);
					System.out.print(1 + " ");
				}else{
					matrix.setValueAt(0, y, x);
					System.out.print(0 + " ");
				}
			}
			System.out.println("");
		}
		return matrix;
	}
	
	public TableModel printMatrixRellenada(Pixel [][] mona ,TableModel matrix){
		this.valuesSingle.clear();
		//System.out.println(" ");
		for(int x=0; x<mona.length; x++){
			for(int y=0; y<mona[x].length; y++){
				//System.out.print(mona[i][j].value + " ");
				if(!this.valuesSingle.contains(mona[x][y].value)){
					this.valuesSingle.add(mona[x][y].value); 
				}
				matrix.setValueAt(mona[x][y].value,y,x);
			}
			//System.out.println("");
		}
		return matrix;
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
		
		//printMatrixRellenada(pixelsMatrix);
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
	
	public void countOnes(Pixel [][] matrix, TableModel matrixCols, TableModel matrixRows){	
		int[]cols = new int[matrix.length];
		int[]rows = new int[matrix.length];
		
		for(int x=0; x<matrix.length; x++){
			int tempRow=0;
			for(int y=0; y<matrix[x].length; y++){
					Pixel tempPix = matrix[x][y];
					tempRow = tempRow+tempPix.value;
					rows[y] = rows[y]+tempPix.value;
					System.out.print(tempPix.value +" ");
					if(y+1 == matrix[y].length){
						System.out.println("T "+tempRow);
						cols[x] = tempRow;
					}
				}
			System.out.println("");
		}
		
		for(int w=0; w<matrixRows.getColumnCount(); w++){
			for(int q=0; q<matrixRows.getRowCount(); q++){
				//System.out.println(matrixRows.getValueAt(q, w)+" q "+q+" w " + w);
				matrixRows.setValueAt(rows[q], q, w);
			}
		}
		
		for(int w=0; w<matrixCols.getColumnCount(); w++){
			for(int q=0; q<matrixCols.getRowCount(); q++){
				System.out.println(matrixCols.getValueAt(q, w)+" q "+q+" w " + w);
				matrixCols.setValueAt(cols[w], q, w);
			}
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
				tempPix.actualizaVecinos(pixelsTemp,tempMatrix);
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
		//this.printArrayMatrix(tempMatrix);
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
					tempPix.actualizaVecinos(pixelsTemp,tempMatrix);
					pixelsTemp.add(tempPix);
					tempMatrix[i][j]= tempPix;
				}
				if(matrix[i][j].value==1){
					llenaPattern(tempMatrix[i][j], tempMatrix);
				}
			}
		}
		//this.printArrayMatrix(tempMatrix);
		return tempMatrix;
	}

	public int cuentaPalitosVecinos(Pixel [][] matrix){
		int count=0;
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				if(matrix[i][j] != null && matrix[i][j].value==1){
					try{
						if(matrix[i+1][j] != null && matrix[i+1][j].value == 1){
							count++;
						}
					}catch(Exception e){}
					try{
						if(matrix[i][j+1] != null && matrix[i][j+1].value == 1){
							count++;
						}
					}catch(Exception e){}
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
	
	public int cuentaOnes(Pixel [][] matrix){//unos en la matrix overall
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
	
	public int[] getHistograma(TableModel matrix){
		int[] histograma = new int[8];
		for (int i =0; i<matrix.getRowCount(); i++){
			for (int j=0; j<matrix.getColumnCount(); j++){
				int value = (int)matrix.getValueAt(i, j);
				histograma[value]++;
			}
		}
		return histograma;
	}
	
	public int[] getHistograma(BufferedImage picture){
		
		int[] histograma = new int[256];
		for(int i=0; i<picture.getWidth(); i++){
			for(int j=0; j<picture.getHeight(); j++){
				try{
					//System.out.println(picture.getRGB(i, j) + " "+i+" "+j );
					int pixel= picture.getRGB(i, j);
					int pixelBB = pixel & 0xFF;
					histograma[pixelBB]++; 
				}catch(Exception w){
					//Out of bounds :(
					System.out.println(i+" "+j );
					System.out.println(w.toString());
				}
			}
		}
		return histograma;
	}
	
	public BufferedImage loadImage(File path){
		try {
			BufferedImage picture = BMPDecoder.read(path);
			return picture;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public BufferedImage loadImage(String path){
		try {
			BufferedImage picture = BMPDecoder.read(new File(path));
			return picture;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public BufferedImage umbralIt (BufferedImage picture,int umbral){
		if(picture == null){
			return null;
		}
		for(int i=0; i<picture.getWidth(); i++){
			for(int j=0; j<picture.getHeight(); j++){
				try{
					//System.out.println(picture.getRGB(i, j) + " "+i+" "+j );
					int pixel= picture.getRGB(i, j);
					int pixelBB = pixel & 0xFF;
					int rgb;
					if(pixelBB < umbral){
						rgb = 0x000000;
					}else{
						rgb= 0xFFFFFF;
					}
					picture.setRGB(i, j, rgb);
				}catch(Exception w){
					//System.out.println(i+" "+j);
				}
			}
		}
		return picture;
	}
	
	public Pixel[][] convertBItoPM(BufferedImage picture){
		this.pixels.clear();
		Pixel[][] pixelMat = new Pixel[picture.getWidth()][picture.getHeight()];
		for(int i=0; i<picture.getWidth(); i++){
			for(int j=0; j<picture.getHeight(); j++){
				try{
					
					int value = (picture.getRGB(i, j) & 0xFF )== 0 ? 0 : 1;
					Pixel currentPixel;
					if(value == 1){
						currentPixel= new Pixel(1,i,j);
					}else{
						currentPixel= new Pixel(0,i,j);
					}
					currentPixel.actualizaVecinos(pixels,pixelMat);
					pixels.add(currentPixel);
					pixelMat[i][j]= currentPixel;
				}catch(Exception w){
					//System.out.println(i+" "+j);
				}
			}
		}
		//this.publicMatrix = pixelMat;
		return pixelMat;	
	}
	
	public int otsuMagicMethod(BufferedImage picture){
		//Implementacion URL: http://www.labbookpages.co.uk/software/imgProc/otsuThreshold.html
		float sumaTodoHistograma = 0;
		float sumB = 0;
		float varMax = 0;
		
		int weightBack = 0;
		int weightFore = 0;
		int magicNumber = 0;//threshold

		int [] histograma = this.getHistograma(picture);
		int numberOfPixels= picture.getHeight()*picture.getWidth();
		
		//Sum all histogram 
		for (int i=0 ; i<histograma.length ; i++){ 
			sumaTodoHistograma += i * histograma[i];
		}
		
		for (int j=0 ; j<histograma.length ; j++) {
			weightBack += histograma[j];
			
			if(weightBack == 0){continue;}
			
			weightFore = numberOfPixels - weightBack;
			if(weightFore == 0) {break;} //we are done
			
			sumB += (float) (j * histograma[j]);
			
			float mB = sumB / weightBack;            // Mean Background
			float mF = (sumaTodoHistograma - sumB) / weightFore;    // Mean Foreground
			
			// Calculate Between Class Variance
		   float varBetween = (float)weightBack * (float)weightFore * (mB - mF) * (mB - mF);

		   // Check if new maximum found
		   if (varBetween > varMax) {
		      varMax = varBetween;
		      magicNumber = j;
		   }
			
		}
		return magicNumber;
	}
	
	public int kittlerIllingworthMethod(BufferedImage picture){
		int [] histograma = this.getHistograma(picture);
		int magicNumber = 0;
		double criteria = 0;
		
		for (int k = 0; k<=255; k++){
			// Calcular parametros 
			int p0=0;
			for (int i = 0; i<=k; i++){
				p0 += histograma[i];
			}
			if(p0==0){continue;}
			
			int p1=0;
			for (int i = k+1; i<=255; i++){
				p1 += histograma[i];
			}
			if(p1==0){continue;}
			
			int u0=0;
			for (int i = 0; i<=k; i++){
				u0 += i*histograma[i];
			}
			u0 = u0/p0;
			
			int u1=0;
			for (int i = k+1; i<=255; i++){
				u1 += i*histograma[i];
			}
			u1 = u1/p1;
			
			double ou0=0;
			for (int i = 0; i<=k; i++){
				ou0 += ((i - u0)*(i - u0))*histograma[i];
			}
			ou0 = Math.sqrt(ou0/p0);
			
			double ou1=0;
			for (int i = k+1; i<=255; i++){
				ou1 += ((i - u1)*(i - u1))*histograma[i];
			}
			ou1 =  Math.sqrt(ou1/p1);
			
			//Funcion criterio
			Double criterioJtemp = 1+ (2*((p0 * Math.log(ou0)) + (p1 * Math.log(ou1)))) - (2*((p0 * Math.log(p0)) + (p1 * Math.log(p1))));
			if(!criterioJtemp.isInfinite()){
				if(criterioJtemp < criteria){
					criteria = criterioJtemp;
					magicNumber = k;
				}
			}
		}
		return magicNumber;
	}

	public int magicianSahooMethod (BufferedImage picture, double alfa){ //0.1
		int [] histograma = this.getHistograma(picture);
		double pi = picture.getHeight() * picture.getWidth(); 
		double criteria = Double.MIN_VALUE;
		int magicNumber = 0;
		
		for (int k = 0; k<=255; k++){
			// Calcular parametros 
			double pA1=0;
			for (int i = 0; i<=k; i++){
				pA1 += histograma[i];
			}
			if(pA1==0){continue;}
			double pA2=0;
			for (int i = k+1; i<=255; i++){
				pA2 += histograma[i];
			}
			if(pA2==0){continue;}
			double sumatoriaPA1 = 0 ;
			for (int i = 0; i<=k; i++){
				sumatoriaPA1 += Math.pow(((double)histograma[i] / pA1),alfa);
			}			
			
			double sumatoriaPA2 = 0 ;
			for (int i = k+1; i<=255; i++){
				sumatoriaPA2 += Math.pow(((double)histograma[i] / pA2),alfa);
			}
			//System.out.println(sumatoriaPA1+" "+sumatoriaPA2);
			double H0=0;
			H0 = (1.0/(1.0-alfa))*Math.log(sumatoriaPA1);
			double H1=0;
			H1 = (1.0/(1.0-alfa))*Math.log(sumatoriaPA2);
			//System.out.println(H0+H1);
			if(H0 + H1 > criteria){
				criteria = H0 + H1;
				magicNumber = k;
			}
		}
		return magicNumber;
	} 

	public String analizaConexiones(){
		String mensaje = "";
		if(this.valuesSingle.contains(2) && this.valuesSingle.contains(3)){
			mensaje = "Contiene imagenes simple conectadas y multiple conectadas.";
		}
		if(this.valuesSingle.contains(2) && !this.valuesSingle.contains(3)){
			mensaje = "Contiene imagenes simple conectadas solamente.";
		}
		if(!this.valuesSingle.contains(2) && this.valuesSingle.contains(3)){
			mensaje = "Contiene imagenes multiple conectadas solamente.";
		}
		if(mensaje.equals("")){
			mensaje= "No pude describir la imagen. =(";
		}
		return mensaje;
	} 

	public BufferedImage generateHistogram(int[]data){
		BufferedImage histo = new BufferedImage( 256, 100, BufferedImage.TYPE_INT_RGB);
		for(int j=0; j<255; j++){
			for(int i=0; i<99; i++){
				histo.setRGB(j, i, 0xFFFFFF);
			}
		}
		int count = 0;
		for(int x=0; x<256; x++){
			count++;
			if(count>=data.length){break;}
			for(int y=0; y<data[count]; y++){
				System.out.println(x+","+y+" a "+data[count]);
				histo.setRGB(x, 99-y, 0x000000);
				//histo.setRGB(j+1, i, 0x000000);
			}
			
		}
	    return histo;
	}
	
	public void segmenta100Imagenes(){
		System.out.println("Segmentar 100 Imagenes");
		for(int i=1; i<101; i++){
			String name = Integer.toString(i);
			if(name.length()==1){name = "00"+name;}
			if(name.length()==2){name = "0"+name;}
			String pathName= "imagenes/IMAG"+name+".BMP"; 
			
			BufferedImage imageLoadOtsu = this.loadImage(pathName);
			BufferedImage imageLoadKittler = this.loadImage(pathName);
			BufferedImage imageLoadSahoo = this.loadImage(pathName);
			
			int number = this.otsuMagicMethod(imageLoadOtsu);
			int numberKI = this.kittlerIllingworthMethod(imageLoadKittler);
			int numberS = this.magicianSahooMethod(imageLoadSahoo, 0.15);
			
			BufferedImage imageOtsuResult = this.umbralIt(imageLoadOtsu, number);//150
			Pixel [][] Otsu = this.convertBItoPM(imageOtsuResult);
			int otsuCount = this.cuentaObjetos(Otsu);
			int otsuCountetiq = this.etiquetaYCuenta(Otsu);
			
			BufferedImage imageKittlerResult = this.umbralIt(imageLoadKittler, numberKI);//150
			Pixel [][] Kittler = this.convertBItoPM(imageKittlerResult);
			int kittlerCount = this.cuentaObjetos(Kittler);
			int kittlerCountetiq = this.etiquetaYCuenta(Kittler); 
			
			BufferedImage imageSahooResult = this.umbralIt(imageLoadSahoo, numberS);//150
			Pixel [][] Sahoo = this.convertBItoPM(imageSahooResult);
			int sahooCount = this.cuentaObjetos(Sahoo);
			int sahooCountetiq = this.etiquetaYCuenta(Sahoo);
			
			System.out.println(name+","+number+","+numberKI+","+numberS+","+otsuCount+","+otsuCountetiq+","+kittlerCount+","+kittlerCountetiq+","+sahooCount+","+sahooCountetiq);
		}
		
	}
	
	public int etiquetaYCuenta (Pixel [][] Matrix){
		ArrayList<Integer> tags =  new ArrayList<Integer>();
		tags.add(2);
		int currentTag = tags.get(tags.size()-1);
		for(int x=0; x<Matrix.length; x++){
			for(int y=0; y<Matrix[x].length; y++){
				if(Matrix[x][y].value==1){
					rellenaCuates(1,currentTag,Matrix[x][y]);
					tags.add(currentTag+1);
					currentTag = tags.get(tags.size()-1);
				}
			}
		}
		return tags.size()-2;
	}
	
	
}

