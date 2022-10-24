package CNS;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class Controller {

    @FXML
    private Button btnCopiarCPF;

    @FXML
    private Button btnCopiarCNS;

    @FXML
    private TextField txtFieldCPF;

    @FXML
    private TextField txtFieldCNS;



    @FXML
    public void copiarCPF() {
        try {
        txtFieldCPF.setText(new GeradorCPF().gerarCpf());
        String cpfgerado = txtFieldCPF.getText();
        StringSelection stringSelectionCPF = new StringSelection(cpfgerado);
        Clipboard clipboardCPF = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardCPF.setContents(stringSelectionCPF, null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @FXML
    public void copiarCNS() {
        txtFieldCNS.setText(new GeradorCns().CNS_gerado_aleatoriamente());
        String cnsgerado = txtFieldCNS.getText();
        StringSelection stringSelectionCNS = new StringSelection(cnsgerado);
        Clipboard clipboardCNS = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboardCNS.setContents(stringSelectionCNS, null);

    }

}
