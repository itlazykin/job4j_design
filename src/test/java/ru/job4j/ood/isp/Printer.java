package ru.job4j.ood.isp;

public class Printer implements MultifunctionDevice {
    @Override
    public void print() {
        System.out.println("Printer print");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Scanner not supported");
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException("Fax not supported");
    }

    @Override
    public void copy() {
        throw new UnsupportedOperationException("Copy not supported");
    }
}
