import java.io.IOException;

public class CLS {
    public static void clear() throws IOException, InterruptedException {
        try{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (Exception e)
		{
		
		}
    }
}