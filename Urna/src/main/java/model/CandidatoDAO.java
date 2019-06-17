/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Victor.Machado
 */
public interface CandidatoDAO {
    public Candidato insert(Candidato candidato);
    public Candidato findById(Long id);
    public Candidato findByNumero(String numero);
    public List<Candidato> findAll();
    public Candidato update(Candidato candidatoA, Candidato N);
    public boolean delete(Candidato candidato);    
}
