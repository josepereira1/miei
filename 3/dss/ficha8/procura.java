
//	PL08:
//	exercício 5:
public List<String> procura(String pChave){
	String num, desc;
	ArrayList<String> res = new ArrayList();

	for(Documento d: documentos.values()){
		desc = d.getDescricao();
		if(desc.contains(pChave)){
			m = d.getNumero();
			res.add(m);
		}
	}
	return res;
}

//	documentos é um Map<String, Documentos> documentos, que está definido
//	na class Facede, ou seja, Mediateca.