Especificação
• Classe Prato– Atributos:
* Número de série (sequencial)
* Nível de sujeira (randômico sobre um Enum (BAIXO, MEDIO, ENGORDURADO))
garantir proporções de 30% BAIXO, 60% MEDIO e 10% EGORDURADO.
• Classe Escorredor– Bufferlimitado implementado como umafilaFIFOcircular queaceita colocar/tirar Pratos.
Você é responsável por implementar a lógica deste buffer.– Aaplicação deve encerrar caso os limites do escorredor foram violados, ou seja, a quanti
dade de pratos deve ser: 0 <= pratos <= MAX.
MAXéaquantidade máxima de pratos que pode ser colocada no escorredor.– Semprequeoescorredor estiver vazio ou cheio, deve-se apresentar uma mensagem na tela
informando o estado e a quantidade de pratos no escorredor.
• Classe PratosSujosFactory– Simula uma pilha de pratos sujos infinita, retorna um novo prato sujo sempre que solici
tada
• Classe Lavador– Runnable– Sincronização com wait/notify sobre o Escorredor– Otrabalho dessa classe consiste em verificar se existe espaço no escorredor
true O lavador solicita um prato sujo e o lava (3ms para prato com nível de sujeira
BAIXO,5msparaMEDIOe10msparaENGORDURADO)–usesleepparaforçar
a thread a esperar o tempo necessário
false O lavador aguarda até que o Escorredor possua um espaço livre– Umacondição de término (done) deve ser usada para indicar o fim da tarefa
Página 1 / 2
• Classe Enxugador– Runnable– Sincronização com wait/notify sobre o Escorredor– Otrabalho dessa classe consiste em verificar se existe algum prato no escorredor
true Retira o prato do Escorredor e o enxuga. O tempo para enxugar varia aleatoriamente
(tempo mínimo de 3ms e máximo de 10ms).
false Descansa aguardando que o lavador faça seu trabalho.
• Classe App– responsável por instanciar a aplicação– Método work() deve ser usado para disparar os trabalhos– Método stop() deve ser usado para encerrar os trabalhos– Método main() cria a aplicação, dispara o início dos trabalhos, aguarda 2 minutos e
solicita o encerramento dos trabalhos.
