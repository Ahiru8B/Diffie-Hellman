package ru.sgu.hell.dh.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import ru.sgu.hell.dh.model.DiffieHellman;
import ru.sgu.hell.dh.model.Person;

@Service
@Slf4j
public class WindowService {
	private Person alice;
	private Person bob;

	public WindowService() {
		log.trace("WindowService constructor");
		DiffieHellman aliceDH = new DiffieHellman();
		DiffieHellman bobDH = new DiffieHellman();
		log.trace("created alice and bob DH");
		bobDH.addG(aliceDH.getG());
		log.trace("bob added g");
		bobDH.addP(aliceDH.getP());
		log.trace("bob added p");
		bobDH.addB(aliceDH.getA());
		log.trace("bob added b");
		aliceDH.addB(bobDH.getA());
		log.trace("alece added b");
		alice = new Person(aliceDH);
		log.trace("Created alice");
		bob = new Person(bobDH);
		log.trace("created alice and bob");
	}

	public Person getAlice() {
		return alice;
	}

	public Person getBob() {
		return bob;
	}

	public void setAlice(Person alice) {
		this.alice = alice;
	}

	public void setBob(Person bob) {
		this.bob = bob;
	}

}
