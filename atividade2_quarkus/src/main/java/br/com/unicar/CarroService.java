package br.com.unicar;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class CarroService {

    private List<Carro> frota = new ArrayList<>();

    public CarroService() {
        // Inicializando frota fictícia para demonstração do Framework
        frota.add(new Carro("ABC-1234", "Fiat Uno", true));
        frota.add(new Carro("XYZ-9876", "Honda Civic", true));
        frota.add(new Carro("QWE-5555", "Toyota Corolla", false)); // Indisponível
    }

    public List<Carro> listarDisponiveis() {
        return frota.stream()
                .filter(Carro::isDisponivel)
                .collect(Collectors.toList());
    }

    public boolean alugarCarro(String placa) {
        Optional<Carro> carroOpt = frota.stream()
                .filter(c -> c.getPlaca().equalsIgnoreCase(placa) && c.isDisponivel())
                .findFirst();

        if (carroOpt.isPresent()) {
            carroOpt.get().setDisponivel(false);
            return true;
        }
        return false;
    }
}
