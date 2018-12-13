import java.io.IOException;
//works for windows only, call the "cls" (clear screen) command
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