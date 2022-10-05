package training.account;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LogOutPrinter extends PrintStream {

    private static final ByteArrayOutputStream OUTPUT_STREAM = new ByteArrayOutputStream();

    private List<String> lines = new ArrayList<String>();
    public LogOutPrinter() {
        super(OUTPUT_STREAM);
    }

    @Override
    public void println(String x) {
        lines.add(x);
    }

    @Override
    public void print(String s) {
        lines.add(s);
    }

    public String all() {
        return String.join("\n", lines);
    }
}
