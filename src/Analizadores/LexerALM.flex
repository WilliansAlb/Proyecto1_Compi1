package Analizadores;
import java_cup.runtime.Symbol;
%%
%class LexerALM
%type java_cup.runtime.Symbol
%cup
%full
%line
%column
%char
%public
L=[a-zA-Z]+
D=[0-9]+
C=[@_"-"%#&]+
espacio=[ |\t|\r|\n]+
esp = [ ]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
/*inicio para formularios*/
("db.formularios") {return new Symbol(symALM.INICIOFORM,yycolumn, yyline, yytext());}

/*inicio para usuarios*/
("db.usuarios") {return new Symbol(symALM.INICIOUSUARIOS, yycolumn, yyline, yytext());}

/*lista de componentes*/
("COMPONENTES") {return new Symbol(symALM.COMPS, yycolumn, yyline, yytext());}

/*conjunto de datos recopilados*/
("DATOS") {return new Symbol(symALM.DATOS, yycolumn, yyline, yytext());}

/*Palabra reservada para creacion de usuario*/
("USUARIO_CREACION") {return new Symbol(symALM.USUARIOCP,yycolumn,yyline,yytext());}

/* Usuario */
("USUARIO") {return new Symbol(symALM.USUARIOP,yycolumn,yyline,yytext());}

/* OR */
("|") {return new Symbol(symALM.OR,yycolumn,yyline,yytext());}

/* Contraseña*/
("PASSWORD") {return new Symbol(symALM.CONTRAP,yycolumn,yyline,yytext());}

/*Fecha de creación*/
("FECHA_CREACION") {return new Symbol(symALM.FECHACP,yycolumn,yyline,yytext());}

/*Palabra reservada para ID*/
("ID_FORM") {return new Symbol(symALM.IDF,yycolumn,yyline,yytext());}

/*Palabra reservada para ID*/
("ID_COMP") {return new Symbol(symALM.IDC,yycolumn,yyline,yytext());}

/*Palabra reservada para Titulo*/
("TITULO") {return new Symbol(symALM.TITULOP,yycolumn,yyline,yytext());}

/*Palabra reservada para nombre*/
("NOMBRE") {return new Symbol(symALM.NOMBREP,yycolumn,yyline,yytext());}

/*Palabra reservada para tema*/
("TEMA") {return new Symbol(symALM.TEMAP,yycolumn,yyline,yytext());}

/*Palabra reservada para tipos de temas*/
("dark"|"blue"|"white"|"DARK"|"BLUE"|"WHITE") {return new Symbol(symALM.TEMA,yycolumn,yyline,yytext());}

/*Palabra reservada para tipos de temas*/
("CENTRO"|"IZQUIERDA"|"DERECHA"|"JUSTIFICAR") {return new Symbol(symALM.ALINEA,yycolumn,yyline,yytext());}

/*Palabra reservada para clases normales*/
("CAMPO_TEXTO"|"FICHERO") {return new Symbol(symALM.CLASENORMAL,yycolumn,yyline,yytext());}

/*Palabra reservada para clases area texto*/
("AREA_TEXTO") {return new Symbol(symALM.CLASEAREA,yycolumn,yyline,yytext());}

/*Palabra reservada para clases con opciones*/
("CHECKBOX"|"RADIO"|"COMBO") {return new Symbol(symALM.CLASEOPCIONES,yycolumn,yyline,yytext());}

/*Palabra reservada para clases de imagen*/
("IMAGEN") {return new Symbol(symALM.CLASEIMAGEN,yycolumn,yyline,yytext());}

/*Palabra reservada para clase de boton*/
("BOTON") {return new Symbol(symALM.CLASEBOTON,yycolumn,yyline,yytext());}

/*Palabra reservada para requerido*/
("SI"|"NO") {return new Symbol(symALM.BOOL,yycolumn,yyline,yytext());}

/*Palabra reservada para nombre del campo*/
("NOMBRE_CAMPO") {return new Symbol(symALM.NOMBREC,yycolumn,yyline,yytext());}

/*Palabra reservada para clase*/
("CLASE") {return new Symbol(symALM.CLASE,yycolumn,yyline,yytext());}

/*Palabra reservada para indice*/
("INDICE") {return new Symbol(symALM.INDICEC,yycolumn,yyline,yytext());}

/*Palabra reservada para el texto visible del componente*/
("TEXTO_VISIBLE") {return new Symbol(symALM.TEXTOVC,yycolumn,yyline,yytext());}

/*Palabra reservada para alineacion*/
("ALINEACION") {return new Symbol(symALM.ALINEAC,yycolumn,yyline,yytext());}

/*Palabra reservada para requerido*/
("REQUERIDO") {return new Symbol(symALM.REQUERIDO,yycolumn,yyline,yytext());}

/*Palabra reservada para opciones*/
("OPCIONES") {return new Symbol(symALM.OPCIONES,yycolumn,yyline,yytext());}

/*Palabra reservada para filas*/
("FILAS") {return new Symbol(symALM.FILAS,yycolumn,yyline,yytext());}

/*Palabra reservada para columnas*/
("COLUMNAS") {return new Symbol(symALM.COLUMNAS,yycolumn,yyline,yytext());}

/*Palabra reservada para url*/
("URL") {return new Symbol(symALM.URLC,yycolumn,yyline,yytext());}

/* Dos puntos */
( ":" ) {return new Symbol(symALM.DOSP, yycolumn, yyline, yytext());}

/* Coma */
( "," ) {return new Symbol(symALM.COMA, yycolumn, yyline, yytext());}

/* Parentesis de apertura */
( "(" ) {return new Symbol(symALM.PARENTESISA, yycolumn, yyline, yytext());}

/* Parentesis de cierre */
( ")" ) {return new Symbol(symALM.PARENTESISC, yycolumn, yyline, yytext());}

/* Llave de apertura */
( "{" ) {return new Symbol(symALM.LLAVEA, yycolumn, yyline, yytext());}

/* Llave de cierre */
( "}" ) {return new Symbol(symALM.LLAVEC, yycolumn, yyline, yytext());}

/* Comillas */
( "\"" ) {return new Symbol(symALM.COMILLAS, yycolumn, yyline, yytext());}

/* Nombre y numero del campo */
("REGISTRO_"{D}+) {return new Symbol(symALM.NOREGISTRO, yycolumn, yyline, yytext());}

/* Numero */
{D}+|{D}+"."{D}+ {return new Symbol(symALM.NUMERO, yycolumn, yyline, yytext());}

/*Fecha*/
{D}{4}"-"({D}{2}"-"|{D}"-")({D}{2}|{D}) {return new Symbol(symALM.FECHA,yycolumn,yyline,yytext());}

/*Usuario token*/
({L}|{D}|{C})+ {return new Symbol(symALM.USUARIO,yycolumn,yyline,yytext());}

/* ID */
("$"|"_"|"-")("$"|"_"|"-"|{D}|{L})* {return new Symbol(symALM.ID,yycolumn,yyline,yytext());}

/*URL*/
("https://")?{L}({L})*"."{L}({L})*".com/"(({L}|{D}|{C})*("/")?)* {return new Symbol(symALM.URL, yycolumn,yyline,yytext());}

/*TITULO*/
({L}|{D})({L}|{D}|{C}|{esp})* {return new Symbol(symALM.TITULO, yycolumn, yyline, yytext());}

/* Espacios en blanco */
{espacio} {/*Ignore*/}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}