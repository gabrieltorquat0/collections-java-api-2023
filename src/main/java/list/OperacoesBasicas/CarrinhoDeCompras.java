package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> carrinhoDeComprasItem;

    public CarrinhoDeCompras() {
        this.carrinhoDeComprasItem = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        this.carrinhoDeComprasItem.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemParaRemover = new ArrayList<>();

        for (Item item : carrinhoDeComprasItem){
            if(item.getNome().equalsIgnoreCase(nome)) {
                itemParaRemover.add(item);
            }
        }
        carrinhoDeComprasItem.removeAll(itemParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Item item : carrinhoDeComprasItem) {
            valorTotal += (item.getPreco() * item.getQuantidade());
        }
        return valorTotal;
    }

    public void exibitItens() {
        System.out.println(this.carrinhoDeComprasItem);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Sabonete", 150.0, 14);
        carrinhoDeCompras.adicionarItem("Shampoo", 120.0, 5);

        System.out.println(carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.exibitItens();

        carrinhoDeCompras.removerItem("Shampoo");
        carrinhoDeCompras.exibitItens();
        System.out.println(carrinhoDeCompras.calcularValorTotal());
    }
}

