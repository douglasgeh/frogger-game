package main;

import java.util.ArrayList;

import jplay.GameObject;
import jplay.Window;

public class AutomovelModule extends MobileElement{

	
	private ArrayList<Automovel> automoveis;
	
	public AutomovelModule(){
		
		super(true);
		
		this.initElements();
	}
	
	@Override
	int checkColisionWithMobileCenarioElement(GameObject player) {
		
		for(int i=0;i<this.automoveis.size();i++){
			
			if(this.automoveis.get(i).collided(player)){
				
				return i;
			}
			
		}
		
		return invalid;

	}

	@Override
	void moveAndDrawMobileElements(Window janela) {
		
		for(int index = 0;index<this.automoveis.size();index++){
			
			this.automoveis.get(index).draw();
			this.automoveis.get(index).mover();
			
			if(this.automoveis.get(index).checkEndOfMap(janela.getWidth())){
				
				this.automoveis.get(index).resetPosition();
			}
			
		}
		
	}

	@Override
	void initElements() {
		
		this.automoveis = new ArrayList();
		
		
		this.automoveis.add(new Automovel(1,450,"caminhao"));
		this.automoveis.add(new Automovel(50, 510, "carroAzul"));
		this.automoveis.add(new Automovel(100, 620, "carroAmarelo"));
		
		
	}

	
	
	
	
}
