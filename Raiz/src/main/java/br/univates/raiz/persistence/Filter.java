package br.univates.raiz.persistence;

public interface Filter<T>
{
    public boolean isAccept(T record);
}
