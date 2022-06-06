package wallettemplate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import network.thunder.core.communication.layer.high.Channel;
import network.thunder.core.etc.Tools;
import org.bitcoinj.core.Coin;

import java.sql.SQLException;
import java.util.Date;

public class ChannelInfoController {

    @FXML
    private HBox topHBox;

    @FXML
    private Label titleLabel;

    @FXML
    private Label labelOpen;

    @FXML
    private Label labelClose;

    @FXML
    private Label balanceClient;

    @FXML
    private Label balanceClientAcc;

    @FXML
    private Label balanceServer;

    @FXML
    private TextField txOpen;

    @FXML
    private TextField txRefund;

    @FXML
    private TextField txChannel;

    @FXML
    private TextField txRevoke;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button cancelBtn1;

    public Main.OverlayUI overlayUI;

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize () throws SQLException {
        assert topHBox != null : "fx:id=\"topHBox\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert titleLabel != null : "fx:id=\"titleLabel\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert labelOpen != null : "fx:id=\"labelOpen\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert labelClose != null : "fx:id=\"labelClose\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert balanceClient != null : "fx:id=\"balanceClient\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert balanceClientAcc != null : "fx:id=\"balanceClientAcc\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert balanceServer != null : "fx:id=\"balanceServer\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert txOpen != null : "fx:id=\"txOpen\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert txRefund != null : "fx:id=\"txRefund\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert txChannel != null : "fx:id=\"txChannel\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert txRevoke != null : "fx:id=\"txRevoke\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'channel_info.fxml'.";
        assert cancelBtn1 != null : "fx:id=\"cancelBtn1\" was not injected: check your FXML file 'channel_info.fxml'.";

        Channel channel = Main.dbHandler.getChannel(0);

        balanceClient.setText(Coin.valueOf(channel.channelStatus.amountClient).toFriendlyString());
        balanceServer.setText(Coin.valueOf(channel.channelStatus.amountServer).toFriendlyString());

        labelOpen.setText(new Date(((long) channel.getTimestampOpen()) * 1000).toString());

        /* ********OpenRefactory Warning********
		 Possible null pointer Dereference!
		 Path: 
			File: ChannelInfoController.java, Line: 83
				txOpen.setText(Tools.bytesToHex(channel.anchorTx.bitcoinSerialize()));
				anchorTx is referenced in method invocation.
		*/
		txOpen.setText(Tools.bytesToHex(channel.anchorTx.bitcoinSerialize()));

    }

    @FXML
    void cancel (ActionEvent event) {
        overlayUI.done();
    }

    @FXML
    void closeChannel (ActionEvent event) throws Exception {
        overlayUI.done();
    }

}
