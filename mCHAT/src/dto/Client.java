/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.net.Socket;

/**
 *
 * @author MAST
 */
public class Client {
    private Socket socket;
    private String nickName;
    
    public Client(Socket socket, String nickName) throws Exception{
        this.setSocket(socket);
        this.setNickName(nickName);
    }
    
    public void setSocket(Socket socket) throws Exception{
        if(socket == null)
            throw new Exception("Socket não fornecido");
        
        this.socket = socket;
    }
    
    public void setNickName(String str) throws Exception{
        if((str == null) || (str.equals("")))
            throw new Exception("Nickname não fornecido");
        
        this.nickName = str;
    }
    
    public Socket getSocket(){
        return this.socket;
    }
    
    public String getNickName(){
        return this.nickName;
    }
}
