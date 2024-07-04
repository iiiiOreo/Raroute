package page7;

import com.spire.pdf.PdfDocument;
import com.spire.pdf.PdfPageBase;
import com.spire.pdf.graphics.PdfImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class PNGToPDFConverter {

    public static void takePath(String path) throws IOException {
        convertImagesToPDF(path, "Ticket.pdf");
    }

    public static void convertImagesToPDF(String inputImagePath, String outputPDFPath) throws IOException {
        // Create a PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Set the margins to 0
        doc.getPageSettings().setMargins(0);

        // Read the PNG image
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(inputImagePath));

        // Create a PdfImage object
        PdfImage pdfImage = PdfImage.fromImage(bufferedImage);

        // Get the image width and height
        int width = pdfImage.getWidth();
        int height = pdfImage.getHeight();

        // Add a page of the same size as the image
        PdfPageBase page = doc.getPages().add(new Dimension(width, height));

        // Draw image at (0, 0) of the page
        page.getCanvas().drawImage(pdfImage, 0, 0, width, height);

        // Save to file
        doc.saveToFile(outputPDFPath);
        System.out.println("PDF created successfully.");
        // Close the document
        doc.close();
    }
}
