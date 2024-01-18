package com.inti.service;

import java.util.List;
import java.util.Optional;

import com.inti.model.Soliste;

/**
 * @author Raphaël EYCHENNE
 */

public interface ISolisteService {

	public List<Soliste> getAllSoliste();
	public Soliste saveSoliste(Soliste sol);
	public Optional<Soliste> getSoliste(Long num);
	public boolean updateSoliste(Soliste sol);
	public void deleteSoliste(Long num);
}
