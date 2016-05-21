/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EXMPLE_PROVES;

/**
 *
 * @author Joanmi
 */
public class proves {
    	public static void provesAnimal() {
		Especie especie1 = new Especie("Elefant", "Elephantidae", "Els elefants són animals molt grans.");
		Especie especie2 = new Especie("Tigre", "Panthera Tigris", "Els tigres es troven al continent asiàtic.");
		Aliment aliment1 = new Aliment("Lletuga variada", "Iceberg, Escarola, Endivia, Romana");
		Aliment aliment2 = new Aliment("Papilla", "Peix, pinso de blat, lletuga",
				"Triturar i mesclar tots els ingredients");
		Aliment aliment3 = new Aliment("Formatge", "Formatge de cabra");
		Animal animal1 = new Animal("Dumbo", especie1);
		animal1.afegirAliment("Lletuga variada", aliment1);
		animal1.afegirAliment("Papilla", aliment2);

		System.out.println(
				"##########################" + "\n## PROVES CLASE ANIMAL  ##" + "\n##########################\n");

		System.out.println("-- PROVES GETTERS --");
		System.out.println("-> animal1.getIdentificadorAnimal(): " + animal1.getIdentificadorAnimal());
		System.out.println("-> animal1.getNom(): " + animal1.getNom());
		System.out.println("-> animal1.getEspecie(): " + animal1.getEspecie());
		System.out.println("-> animal1.getLlistaAlimentsAnimal(): " + animal1.getLlistaAlimentsAnimal());

		System.out.println("\n\n-- PROVES SETTERS --");
		System.out.println("nom de l'animal1: " + animal1.getNom()
				+ "\nAra el cambiam per un altre amb animal1.setNom(\"String\");");
		animal1.setNom("Anacleto");
		System.out.println("nom de l'animal1: " + animal1.getNom());

		System.out.println("\nespecie de l'animal1: " + animal1.getEspecie()
				+ "\nAra el cambiam per una altre especie animal1.setEspecie(especie2);");
		animal1.setEspecie(especie2);
		System.out.println("especie de l'animal1: " + animal1.getEspecie());

		System.out.println("\n\n -- PROVES METODES --");
		System.out.println("llista d'aliments: " + animal1.getLlistaAlimentsAnimal());
		System.out.println("\n-- Inserim un nou aliment amb animal1.afegirAliment(\"String\", aliment3);");
		animal1.afegirAliment("Formatge", aliment3);
		System.out.println("-- Comprovam que s'ha afegit a la llista d'aliments: " + animal1.getLlistaAlimentsAnimal());
		System.out.println("\n-- Ara eliminarem l'aliment2 amb animal1.eliminarAliment(\"Papilla\");");
		animal1.eliminarAliment("Papilla");
		System.out
				.println("Comprovam que s'ha eliminat correctament de la llista: " + animal1.getLlistaAlimentsAnimal());
	}
	/**
	 * Prueba de la clase Aliment
	 */
	public static void provesAliment() {
		Aliment aliment1 = new Aliment("Carn", "Carn crua");
		Aliment aliment2 = new Aliment("Papilla", "Pinso de verdura, Aigua, Polvos", "Mesclar tots els ingredients");

		System.out.println(
				"##########################" + "\n## PROVES CLASE ALIMENT ##" + "\n##########################\n");

		System.out.println("-- PROVES GETTERS --");
		System.out.println("-> aliment1.getNomAliment(): " + aliment1.getNomAliment());
		System.out.println("-> aliment1.getIngredient(): " + aliment1.getIngredients());
		System.out.println("-> aliment1.getPreparacio(): " + aliment1.getPreparacio()
				+ "  <-- Null perque no hem inserit informació ja que és opcional");
		System.out.println("-> aliment2.getPreparacio(): " + aliment2.getPreparacio());

		System.out.println("\n\n-- PROVES SETTERS --");
		System.out.println("nom de l'aliment1: " + aliment1.getNomAliment()
				+ "\nAra el cambiam per un altre amb aliment1.setNomAliment(\"String\");");
		aliment1.setNomAliment("Verdura");
		System.out.println("nom de l'aliment1: " + aliment1.getNomAliment());

		System.out.println("\ningredients de l'aliment1: " + aliment1.getIngredients()
				+ "\nAra els cambiam per uns altres amb aliment1.setIngredients(\"String\");");
		aliment1.setIngredients("Farina, ous, pinso, sal.");
		System.out.println("ingredients de l'aliment1: " + aliment1.getIngredients());

		System.out.println("\npreparació de l'aliment1: " + aliment1.getPreparacio()
				+ "\nEn aquest cas es null, afegirem una preparacio amb aliment1.setPreparacio(\"String\");");
		aliment1.setPreparacio("Farina 50%, 2ous, 300gr pinso, 1 cullerada de sal, mesclar tot.");
		System.out.println("preparació de l'aliment1: " + aliment1.getPreparacio());
	}
}
