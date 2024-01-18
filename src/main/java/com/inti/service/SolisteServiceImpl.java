package com.inti.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.model.Soliste;
import com.inti.repository.ISolisteRepository;

@Service
public class SolisteServiceImpl implements ISolisteService {
	
	@Autowired
	ISolisteRepository isr;

	@Override
	public List<Soliste> getAllSoliste() {
		return isr.findAll();
	}

	@Override
	public Soliste saveSoliste(Soliste sol) {
		if(sol != null)
			return isr.save(sol);
		return null;
	}

	@Override
	public Optional<Soliste> getSoliste(Long num) {
		return isr.findById(num);
	}

	@Override
	public boolean updateSoliste(Soliste sol) {
		if(Objects.nonNull(sol)) {
			isr.save(sol);
			return true;
		}
		
		return false;
	}

	@Override
	public void deleteSoliste(Long num) {
		if(Objects.nonNull(num))
			isr.deleteById(num);
	}

}
