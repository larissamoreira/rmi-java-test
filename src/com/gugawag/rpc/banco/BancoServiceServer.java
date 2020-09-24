package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<Conta>();
        contas.add(new Conta("1", 100.0));
        contas.add(new Conta("2", 156.0));
        contas.add(new Conta("3", 950.0));
    }

    public void adicionarConta(String numero, Double saldo) throws RemoteException {
        Conta c = new Conta(numero, saldo);
        contas.add(c);
    }

    @Override
    public double saldo(String numero) throws RemoteException {
        double saldo = 0;
        for(Conta c : contas) {
            if(c.getNumero().equals(numero)) {
                return c.getSaldo();
            } else {
                saldo = 0;
            }
        }
        return saldo;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

}
