==============
README do projeto
==============
!!!Este ficheiro foi deixado propositamente no cvs e não deve ser considerado lixo
==============
Informacao sobre implementacao do projeto
==============

i) Nao fizemos try catch às funções do input para deixar o
código mais limpo, e porque assumimos que caso alguma destas funções faça throw
é suposto o programa de executar imediatamente.

ii) Temos 2 visitor's no textui praticamente iguais, pois na
package edt-support, existem mensagens iguais (mesmo nome da funcao),
mas em packages diferentes, pelo que considerámos necessário usar
packages diferentes para cada uma destas, caso no futuro seja decidido mudar
as mensagens do edt.textui.main e do edt.textui.section para serem diferentes.

iii) No edt.textui.section, o nosso segundo receiver é um DocumentEditor e não
um Document, por 2 motivos:
  1) Manter informação sobre o dirtyBit correta sem ser necessário transformar
  o DocumentEditor numa facade
  2) Ser possível utilizar o DocumentEditor para eventualmente gravar um
  ficheiro a partir de qualquer subMenu

iv) O visitor utiliza uma array de strings para facilitar o output caso as
Messages do edt.support sejam alteradas no futuro
(em vez de armazenar o output numa só string)

v) Atualmente qualquer objeto string é um identificador válido. Incluido null,
"" e strings não imprimiveis. A ideia seria, caso o input do utilizador não
seja um id válido, o core faça throw de IllegalArgumentException e o textui
posteriormente apanhe o throw e possivelmente imprima uma informação para o
utilizador de que o input é inválido.


Basicamente, tentamos ao longo de toda a implementação do projeto deixá-lo o
mais versátil possível para mudanças de especificações possíveis.
