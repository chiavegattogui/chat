/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mchat;

import java.io.IOException;
import util.Final;

/**
 *
 * @author MAST
 */
public class MainClass {
    public static void main(String[] args) 
			throws IOException {
		new RoomChat(Final.PORT).executa();
	}
}
