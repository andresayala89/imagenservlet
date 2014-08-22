package bosque;

/*
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  Presentado por: Jorge Andres Ayala Valero 
 */

@WebServlet(urlPatterns = {"/ImagenServlet"})
public class servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 /** InputStream guarda la ubicacion del archivo */
        
          InputStream archivo = new FileInputStream("e:\\BigImageMix.jpg");
        //InputStream file = new FileInputStream("e:\\imagen.jpg");
            ServletOutputStream salida = response.getOutputStream();
            
  /** BufferedInputStream lee partir de un archivo leer los bytes 
   * ya sea de tamaño determinado o en su totalidad) y transformándolos en  Strings
   */  
            BufferedInputStream bufinst = new BufferedInputStream(archivo);
            BufferedOutputStream bufoust = new BufferedOutputStream(salida);
              
           byte[] outputByte = new byte[4096];
while(bufinst.read(outputByte, 0, 4096) != -1)
{
	bufoust.write(outputByte, 0, 4096);
        bufoust.flush();
}
            bufinst.close();
            archivo.close();
            bufoust.close();
            salida.close();
            /*
            int cont =0;
            while((cont=bufinst.read())!=-1)
            {
                bufoust.write(cont);
                bufoust.flush();
            }
            bufinst.close();
            archivo.close();
            bufoust.close();
            salida.close();
            */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. ">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Descripcion corta";
    }// </editor-fold>
}