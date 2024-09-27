package helpers;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import modelo.Financiamento;

public final class ArquivoHelpers {
    public static void adicionarQuebraDeLinha(StringBuilder sb) {
        sb.append("\n");
    }

    public static void SalvarArquivo(String conteudo, String nomeDoArquivo) throws Exception {
        FileWriter writer = null;

        try {
            writer = new FileWriter(nomeDoArquivo, false);
            writer.write(conteudo);
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(ex.getMessage());
        } catch (Exception e) {
            throw new Exception("Um erro ocorreu ao tentar escrever dados em arquivo.", e);
        } finally {
            writer.flush();
            writer.close();
        }
    }

    public static String AbrirArquivoComoString(String nomeDoArquivo) throws Exception {
        FileReader reader = null;
        var sb = new StringBuilder();
        try {
            int caractereLido;
            reader = new FileReader(nomeDoArquivo);

            while ((caractereLido = reader.read()) != -1) {
                sb.append((char) caractereLido);
            }
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException(ex.getMessage());
        } catch (Exception e) {
            throw new Exception("Um erro ocorreu ao abrir um arquivo.", e);
        } finally {
            reader.close();
        }

        return sb.toString();
    }

    public static void SalvarArquivoComoObjeto(Object objeto,
            String nomeDoArquivo) throws Exception {
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(nomeDoArquivo));
            outputStream.writeObject(objeto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            outputStream.flush();
            outputStream.close();
        }
    }

    public static ArrayList<Financiamento> LerArquivoComoListaObjetoFinanciamento(String nomeDoArquivo)
            throws Exception {
        ObjectInputStream inputStream = null;
        ArrayList<Financiamento> listaRetorno = new ArrayList<>();

        try {
            Object objeto = null;
            inputStream = new ObjectInputStream(new FileInputStream(nomeDoArquivo));
            while ((objeto = inputStream.readObject()) != null) {
                listaRetorno = (ArrayList) objeto;
            }

        } catch (EOFException ex) {
            return listaRetorno;
        } catch (Exception e) {
            e.getMessage();
        } finally {
            inputStream.close();
        }

        return listaRetorno;
    }
}
