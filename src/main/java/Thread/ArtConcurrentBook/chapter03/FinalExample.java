package Thread.ArtConcurrentBook.chapter03;

public class FinalExample {
    int i; // ��ͨ����
    final int j; // final����
    static FinalExample obj;

    public FinalExample() { // ���캯��
	i = 1; // д��ͨ��
	j = 2; // дfinal��
    }

    public static void writer() { // д�߳�Aִ��
	obj = new FinalExample();
	System.out.println(obj.i);
	System.out.println(obj.j);
    }

    public static void reader() { // ���߳�Bִ��
	FinalExample object = obj; // ����������
	int a = object.i; // ����ͨ��
	int b = object.j; // ��final��
	System.out.println(a);
	System.out.println(b);
    }

    public static void main(String args[]) {
	new Thread() {
	    @Override
	    public void run() {
		new FinalExample().reader();
	    }
	}.start();

	new Thread() {
	    @Override
	    public void run() {
		new FinalExample().writer();
	    }
	}.start();
    }
}