package practice_1;


class Box{
	int a, b, c;
	int volume(){
		return a*b*c;
	}
}

class Main{
	public static void main(String[] args){
		Box box = new Box();
		box.a = 10;
		box.b = 10;
		box.c = 10;
		System.out.println(box.volume());
	}
}
