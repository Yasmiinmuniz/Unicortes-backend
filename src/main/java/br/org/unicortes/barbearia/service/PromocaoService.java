package br.org.unicortes.barbearia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.org.unicortes.barbearia.model.Promocao;
import br.org.unicortes.barbearia.repository.PromocaoRepository;

@Service
public class PromocaoService implements PromocaoServiceInterface{

    @Autowired
	private PromocaoRepository repository;

    @Transactional
    public Promocao savePromocao(Promocao promocao){
        return repository.save(promocao);
    };

    @Transactional
    public Promocao updatePromocao(Long id, Promocao promocao){
        promocao.setId(id);

        return repository.save(promocao);
    };

    @Transactional
    public void deletePromocao(Long id){
        repository.deleteById(id);
    };

}
