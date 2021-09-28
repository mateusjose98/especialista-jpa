# Especialista JPA - Alga Works Treinamentos


## Modelo de Dom�nio:

![alt text](https://raw.githubusercontent.com/algaworks/curso-especialista-jpa/master/diagrama-domain-model-especialista-jpa/EJPA%20-%20Domain%20Model.jpg =250x250)


## Constraints do REST:

	- Aplica��es independentes Cliente/Servidor
	- Stateless: a aplica��o n�o deve possuir estado. Uma req. feita ao servidor deve ter tudo que � necess�rio para fazera opera��o.
	- Cache: a aplica��o pode cachear as requisi��es que n�o mudam com frequ�ncia (podemos ter um servidor proxy para tal).
	- Interface uniforme: conjunto de opera��es BEM definidas no sistema. Usamos URIs em cima do protocolo HTTP neste caso.
	- Sistema em camadas
	- C�digo sob demanda
	
OBS.: Restful � um sistema/API que usa as constraints do REST.

## Recursos REST

	- � qualquer coisa exposta na Web, como um documento, uma foto, um pdf, etc. Tem import�ncia suficiente para ser algo representado no software.
	- � como uma "inst�ncia de uma classe"
	- Singleton Resource (recurso �nico) x Collection Resource (cole��es de objetos semelhantes)


## Modelo de maturidade de Richardson:

![alt text](https://martinfowler.com/articles/images/richardsonMaturityModel/overview.png)
