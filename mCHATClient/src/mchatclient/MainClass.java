/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mchatclient;

import java.io.IOException;
import java.net.UnknownHostException;
import util.Final;

/**
 *
 * @author MAST
 */
public class MainClass {
    public static void main(String[] args) 
			throws UnknownHostException,	IOException {
		new ClientSpeak(Final.HOST, Final.PORT).executa();
	}
}
