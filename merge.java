import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;


public class merge {

	public static void main(String[] args) {
		//creating alist called li 
        List<InputStream> li = new ArrayList<InputStream>();
        try {
            // Source pdfs
            list.add(new FileInputStream(new File("f:/1.pdf")));
            list.add(new FileInputStream(new File("f:/2.pdf")));

            // Resulting pdf
            OutputStream out = new FileOutputStream(new File("f:/result.pdf"));

            doMerge(list, out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
