package br.edu.ifpb.newsrestful.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ifpb.edu.newsrestful.entity.News;
import br.ifpb.edu.newsrestfull.DAO.DAO;
import br.ifpb.edu.newsrestfull.DAO.NewsDAO;

public class TestAll {

	@Test
	public void insertNoticia() {
		DAO.abrir();
		NewsDAO newsDAO = new NewsDAO();
		newsDAO.begin();
		int before = newsDAO.listar().size() + 2;
		newsDAO.persistir(new News("Estudante salva homem engasgado antes de entrevista para vaga de paramédico",
				"Um estudante norte-americano salvou a vida de um homem enquanto aguardava uma"
						+ " entrevista de estágio de paramédico. O caso ocorreu na última quarta-feira"
						+ " (9) em uma cafeteria de San Luis Obispo, na Califórnia (EUA). Will Stewart"
						+ " t... - Veja mais em https://noticias.uol.com.br/saude/ultimas-noticias/reda"
						+ "cao/2017/08/11/estudante-salva-homem-engasgado-antes-de-entrevista-para-vaga-"
						+ "de-paramedico.htm?cmpid=copiaecola",
				"Maria Carla Andrade"));
		newsDAO.persistir(new News("Após quase 5 meses desaparecido, Bruno Borges retorna para casa no Acre",
				"Após quase cinco meses desaparecido, o estudante de psicologia Bruno Borges,"
						+ " de 25 anos, retornou para casa na manhã desta sexta-feira (11). A informação"
						+ " foi confirmada pelo pai do jovem, o empresário Athos Borges."
						+ "Borges relatou que filho está bem e a família aliviada com a volta dele. No entanto"
						+ ", o jovem não deve ficar na casa onde morava com os pais e irmãos devido à busca de"
						+ " pessoas curiosas pela história do estudante.",
				"Maria Carla Andrade"));
		int after = newsDAO.listar().size();
		newsDAO.commit();
		DAO.fechar();
		assertEquals(after, before);
	}
}
