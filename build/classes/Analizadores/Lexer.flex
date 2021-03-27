package Analizadores;
import java_cup.runtime.Symbol;
%%
%class Lexer
%type java_cup.runtime.Symbol
%cup
%full
%line
%column
%char
%public
L=[a-zA-Z]+
D=[0-9]+
C=[@_"-"%#&:]+
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
/* palabras reservadas */
<YYINITIAL> ":"                 {return new Symbol(sym.DOSP, yycolumn, yyline, yytext());}
<YYINITIAL> ","                 {return new Symbol(sym.COMA, yycolumn, yyline, yytext());}
<YYINITIAL> "("                 {return new Symbol(sym.Parentesis_a, yycolumn, yyline, yytext());}
<YYINITIAL> ")"                 {return new Symbol(sym.Parentesis_c, yycolumn, yyline, yytext());}
<YYINITIAL> "{"                 {return new Symbol(sym.LLAVEA, yycolumn, yyline, yytext());}
<YYINITIAL> "}"                 {return new Symbol(sym.LLAVEC, yycolumn, yyline, yytext());}
<YYINITIAL> "["                 {return new Symbol(sym.CORCHETEA, yycolumn, yyline, yytext());}
<YYINITIAL> "]"                 {return new Symbol(sym.CORCHETEC, yycolumn, yyline, yytext());}
<YYINITIAL> "\""                {return new Symbol(sym.COMILLAS, yycolumn, yyline, yytext());}
<YYINITIAL> "<!"                {return new Symbol(sym.INICIOE,yycolumn,yyline,yytext());}
<YYINITIAL> "!>"                {return new Symbol(sym.FINE,yycolumn,yyline,yytext());}
<YYINITIAL> "<"                 {return new Symbol(sym.MENORQ,yycolumn,yyline,yytext());}
<YYINITIAL> ">"                 {return new Symbol(sym.MAYORQ,yycolumn,yyline,yytext());}
<YYINITIAL> "|"                 {return new Symbol(sym.OR,yycolumn,yyline,yytext());}
<YYINITIAL> "ini_solicitud:"     {return new Symbol(sym.INICIOS, yycolumn, yyline, yytext());}
<YYINITIAL> "fin_solicitud"     {return new Symbol(sym.FINS,yycolumn,yyline,yytext());}
<YYINITIAL> "ini_solicitudes"   {return new Symbol(sym.SOLICITUDESP, yycolumn, yyline, yytext());}
<YYINITIAL> "fin_solicitudes"   {return new Symbol(sym.FINSOLICITUDES, yycolumn, yyline, yytext());}
<YYINITIAL> "CREAR_USUARIO"     {return new Symbol(sym.CREARU,yycolumn,yyline,yytext());}
<YYINITIAL> "USUARIO"           {return new Symbol(sym.USUARIOP,yycolumn,yyline,yytext());}
<YYINITIAL> "PASSWORD"          {return new Symbol(sym.CONTRAP,yycolumn,yyline,yytext());}
<YYINITIAL> "FECHA_CREACION"    {return new Symbol(sym.FECHACP,yycolumn,yyline,yytext());}
<YYINITIAL> "MODIFICAR_USUARIO" {return new Symbol(sym.MODIFICARU,yycolumn,yyline,yytext());}
<YYINITIAL> "USUARIO_ANTIGUO"   {return new Symbol(sym.USUARIOAP,yycolumn,yyline,yytext());}
<YYINITIAL> "USUARIO_NUEVO"     {return new Symbol(sym.USUARIONP,yycolumn,yyline,yytext());}
<YYINITIAL> "NUEVO_PASSWORD"    {return new Symbol(sym.NUEVOP,yycolumn,yyline,yytext());}
<YYINITIAL> "FECHA_MODIFICACION"                                                {return new Symbol(sym.FECHAMP,yycolumn,yyline,yytext());}
<YYINITIAL> "ELIMINAR_USUARIO"  {return new Symbol(sym.ELIMINARU,yycolumn,yyline,yytext());}
<YYINITIAL> "LOGIN_USUARIO"     {return new Symbol(sym.LOGINU,yycolumn,yyline,yytext());}
<YYINITIAL> "NUEVO_FORMULARIO"  {return new Symbol(sym.NUEVOFP,yycolumn,yyline,yytext());}
<YYINITIAL> "ID"                {return new Symbol(sym.IDP,yycolumn,yyline,yytext());}
<YYINITIAL> "TITULO"            {return new Symbol(sym.TITULOP,yycolumn,yyline,yytext());}
<YYINITIAL> "NOMBRE"            {return new Symbol(sym.NOMBREP,yycolumn,yyline,yytext());}
<YYINITIAL> "TEMA"              {return new Symbol(sym.TEMAP,yycolumn,yyline,yytext());}
<YYINITIAL> "USUARIO_CREACION"  {return new Symbol(sym.USUARIOCP,yycolumn,yyline,yytext());}
<YYINITIAL> ("dark"|"blue"|"white"|"DARK"|"BLUE"|"WHITE"|"Dark"|"Blue"|"White")   {return new Symbol(sym.TEMA,yycolumn,yyline,yytext());}
<YYINITIAL> "CENTRO"|"IZQUIERDA"|"DERECHA"|"JUSTIFICAR"                         {return new Symbol(sym.ALINEA,yycolumn,yyline,yytext());}
<YYINITIAL> ("CAMPO_TEXTO"|"FICHERO")                                             {return new Symbol(sym.CLASENORMAL,yycolumn,yyline,yytext());}
<YYINITIAL> "AREA_TEXTO"                                                        {return new Symbol(sym.CLASEAREA,yycolumn,yyline,yytext());}
<YYINITIAL> ("CHECKBOX"|"RADIO"|"COMBO")                                          {return new Symbol(sym.CLASEOPCIONES,yycolumn,yyline,yytext());}
<YYINITIAL> "IMAGEN"                                                            {return new Symbol(sym.CLASEIMAGEN,yycolumn,yyline,yytext());}
<YYINITIAL> "BOTON"                                                             {return new Symbol(sym.CLASEBOTON,yycolumn,yyline,yytext());}
<YYINITIAL> "SI"|"NO"                                                           {return new Symbol(sym.BOOL,yycolumn,yyline,yytext());}
<YYINITIAL> "ELIMINAR_FORMULARIO"                                               {return new Symbol(sym.ELIMINARF,yycolumn,yyline,yytext());}
<YYINITIAL> "MODIFICAR_FORMULARIO"                                              {return new Symbol(sym.MODIFICARF,yycolumn,yyline,yytext());}
<YYINITIAL> "PARAMETROS_FORMULARIO"                                             {return new Symbol(sym.PARAMF,yycolumn,yyline,yytext());}
<YYINITIAL> "AGREGAR_COMPONENTE"                                                {return new Symbol(sym.AGREGARC,yycolumn,yyline,yytext());}
<YYINITIAL> "NOMBRE_CAMPO"      {return new Symbol(sym.NOMBREC,yycolumn,yyline,yytext());}
<YYINITIAL> "FORMULARIO"        {return new Symbol(sym.FORMULARIOC,yycolumn,yyline,yytext());}
<YYINITIAL> "CLASE"             {return new Symbol(sym.CLASE,yycolumn,yyline,yytext());}
<YYINITIAL> "INDICE"            {return new Symbol(sym.INDICEC,yycolumn,yyline,yytext());}
<YYINITIAL> "TEXTO_VISIBLE"     {return new Symbol(sym.TEXTOVC,yycolumn,yyline,yytext());}
<YYINITIAL> "ALINEACION"        {return new Symbol(sym.ALINEAC,yycolumn,yyline,yytext());}
<YYINITIAL> "REQUERIDO"         {return new Symbol(sym.REQUERIDO,yycolumn,yyline,yytext());}
<YYINITIAL> "OPCIONES"          {return new Symbol(sym.OPCIONES,yycolumn,yyline,yytext());}
<YYINITIAL> "FILAS"             {return new Symbol(sym.FILAS,yycolumn,yyline,yytext());}
<YYINITIAL> "COLUMNAS"          {return new Symbol(sym.COLUMNAS,yycolumn,yyline,yytext());}
<YYINITIAL> "URL"               {return new Symbol(sym.URLC,yycolumn,yyline,yytext());}
<YYINITIAL> "ELIMINAR_COMPONENTE"                                               {return new Symbol(sym.ELIMINARC,yycolumn,yyline,yytext());}
<YYINITIAL> "PARAMETROS_COMPONENTE"                                             {return new Symbol(sym.PARAMC,yycolumn,yyline,yytext());}
<YYINITIAL> "MODIFICAR_COMPONENTE"                                              {return new Symbol(sym.MODIFICARC,yycolumn,yyline,yytext());}
<YYINITIAL> "CREDENCIALES_USUARIO"                                              {return new Symbol(sym.CREDENCIALES,yycolumn,yyline,yytext());}
{espacio}           {/*Ignore*/}
<YYINITIAL> {
    {D}+|{D}+"."{D}+ {return new Symbol(sym.NUMERO, yycolumn, yyline, yytext());}
    {D}{4}"-"({D}{2}"-"|{D}"-")({D}{2}|{D}) {return new Symbol(sym.FECHA,yycolumn,yyline,yytext());}
    ({L}|{D}|{C})+ {return new Symbol(sym.USUARIO,yycolumn,yyline,yytext());}
    ("$"|"_"|"-")("$"|"_"|"-"|{D}|{L})* {return new Symbol(sym.ID,yycolumn,yyline,yytext());}
    ("https://")?{L}({L})*"."{L}({L})*".com/"(({L}|{D}|{C})*("/")?)* {return new Symbol(sym.URL, yycolumn,yyline,yytext());}
    ({L}|{D})(({esp})*({L}|{D}|{C}))* {return new Symbol(sym.TITULO, yycolumn, yyline, yytext());}
}
