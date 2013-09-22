import java.util.ArrayList;


public class PixelRo {

	int value,x,y;
	Pixel [] vecinitos = new Pixel [8];
	Boolean isBoundary = false;
	Boolean startPixel = false;
	
	public Pixel(int val, int posx,int posy) {
		// TODO Auto-generated constructor stub
		this.value = val;
		this.x = posx;
		this.y = posy;
	}
	
	public void setVecino(Pixel pix){
		int vecinoPlace = cualVecino(pix);
		if(vecinoPlace< 8){
			//System.out.println("Pix "+pix.x+","+pix.y+" es de "+this.x+","+this.y+" in "+vecinoPlace);
			this.vecinitos[vecinoPlace] = pix;
			pix.vecinitos[mirrorPlace(vecinoPlace)]=this;
		}else{
			//no es vecino
		}
	}
	
	public int cualVecino(Pixel pix){
		//System.out.println("Debug1 "+pix.x+","+pix.y+" "+this.x+","+this.y);
		if(pix.x==this.x-1){
			if(pix.y==this.y-1){
				return 1;
			}
			if(pix.y==this.y+1){
				return 7;
			}
			if(pix.y==this.y){
				return 0;
			}
		}
		if(pix.x==this.x){
			//System.out.println("Debug "+pix.y+" "+this.y+" "+(this.y-1));
			if(pix.y==this.y-1){
				return 2;
			}
			if(pix.y==this.y+1){
				return 6;
			}
		}
		if(pix.x==this.x+1){
			if(pix.y==this.y-1){
				return 3;
			}
			if(pix.y==this.y+1){
				return 5;
			}
			if(pix.y==this.y){
				return 4;
			}
		}
		
		return 8;
	}
	
	public int mirrorPlace(int place){
		//System.out.println("Place "+place);
		switch(place){
		case 1:
			return 5;
		case 2:
			return 6;
		case 3:
			return 7;
		case 4:
			return 0;
		case 5:
			return 1;
		case 6:
			return 2;
		case 7:
			return 3;
		case 0:
			return 4;
		}
		return 8;
	}
	
	public void actualizaVecinos(ArrayList<Pixel> pixels, Pixel[][] Matrix){
		try{
			if(Matrix[this.x-1][this.y] != null){ //vecinos en 0
				Pixel temp = Matrix[this.x-1][this.y];
				setVecino(temp);
			}
		}catch(Exception e){}
		try{
			if(Matrix[this.x-1][this.y-1] != null){ //vecinos en 1
				Pixel temp = Matrix[this.x-1][this.y-1];
				setVecino(temp);
			}	
		}catch(Exception e){}
		try{
			if(Matrix[this.x][this.y-1] != null){ //vecinos en 2
				Pixel temp = Matrix[this.x][this.y-1];
				setVecino(temp);
			}
		}catch(Exception e){}
		try{
			if(Matrix[this.x+1][this.y-1] != null){ //vecinos en 3
				Pixel temp = Matrix[this.x+1][this.y-1];
				setVecino(temp);
			}
		}catch(Exception e){}
		try{
			if(Matrix[this.x+1][this.y] != null){ //vecinos en 4
				Pixel temp = Matrix[this.x+1][this.y];
				setVecino(temp);
			}
		}catch(Exception e){}
		try{
			if(Matrix[this.x+1][this.y+1] != null){ //vecinos en 5
				Pixel temp = Matrix[this.x+1][this.y+1];
				setVecino(temp);
			}
		}catch(Exception e){}
		try{
			if(Matrix[this.x][this.y+1] != null){ //vecinos en 6
				Pixel temp = Matrix[this.x][this.y+1];
				setVecino(temp);
			}
		}catch(Exception e){}
		try{
			if(Matrix[this.x-1][this.y+1] != null){ //vecinos en 7
				Pixel temp = Matrix[this.x-1][this.y+1];
				setVecino(temp);
			}
		}catch(Exception e){}
		
		//System.out.println("pixel "+this.x+""+y);
		/*for(int i=0; i<vecinitos.length; i++){
			if(vecinitos[i] != null){
				System.out.println( i+" "+vecinitos[i].x+","+vecinitos[i].y);
			}
			else{
				System.out.println( i+" null");
			}
		}*/
	}
	
	public Pixel getVecinoClock(){
		//System.out.println(this.x + " - " +this.y );
		Pixel previous= null;
		for(int i=0; i< this.vecinitos.length; i++){
			Pixel tempVecino = this.vecinitos[i];
			if(tempVecino==null){ continue; }
			//System.out.println("Ve "+i+" - "+tempVecino.value);
			if(i == 0){
				previous = this.vecinitos[7];
			}
			if(tempVecino.value == 1 && previous.value==0){
				this.handleDiagonal(i);
				return tempVecino;
			}
			previous=tempVecino;
		}
		return null;
	}
	
	public Pixel getTheOne(){
		for(Pixel theOne :this.vecinitos){
			if(theOne.value == 1){
				return theOne;
			}
		}
		return null;
	}
	
	public void handleDiagonal(int index){
		if(index % 2 == 1){
			if(this.vecinitos[(index+1)%8].value==1){
				this.vecinitos[(index+1)%8].isBoundary=true;
			}
		}
	}
	

}
