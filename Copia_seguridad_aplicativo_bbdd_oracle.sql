--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "SYSTEM"."ROLES_USUARIOS_APLICATIVO" DROP CONSTRAINT "USUARIO_FK_APLICATIVO";

ALTER TABLE "SYSTEM"."USUARIOS_APLICATIVO" DROP CONSTRAINT "SYS_C007010";

ALTER TABLE "SYSTEM"."ROLES_USUARIOS_APLICATIVO" DROP CONSTRAINT "SYS_C007014";

DROP INDEX "SYSTEM"."USUARIOS_APLICATIVO_UNICO";

DROP INDEX "SYSTEM"."SYS_C007010";

DROP INDEX "SYSTEM"."SYS_C007014";

DROP TABLE "SYSTEM"."USUARIOS_APLICATIVO";

DROP TABLE "SYSTEM"."ROLES_USUARIOS_APLICATIVO";

CREATE TABLE "SYSTEM"."USUARIOS_APLICATIVO" (
		"USUARIO" VARCHAR2(60) NOT NULL,
		"VALIDO" NUMBER(1 , 0)
	);

CREATE TABLE "SYSTEM"."ROLES_USUARIOS_APLICATIVO" (
		"ID" NUMBER NOT NULL,
		"USUARIO" VARCHAR2(45),
		"ROL_USUARIO" VARCHAR2(45)
	);

CREATE UNIQUE INDEX "SYSTEM"."USUARIOS_APLICATIVO_UNICO" ON "SYSTEM"."ROLES_USUARIOS_APLICATIVO" ("USUARIO" ASC, "ROL_USUARIO" ASC);

CREATE UNIQUE INDEX "SYSTEM"."SYS_C007010" ON "SYSTEM"."USUARIOS_APLICATIVO" ("USUARIO" ASC);

CREATE UNIQUE INDEX "SYSTEM"."SYS_C007014" ON "SYSTEM"."ROLES_USUARIOS_APLICATIVO" ("ID" ASC);

ALTER TABLE "SYSTEM"."USUARIOS_APLICATIVO" ADD CONSTRAINT "SYS_C007010" PRIMARY KEY ("USUARIO");

ALTER TABLE "SYSTEM"."ROLES_USUARIOS_APLICATIVO" ADD CONSTRAINT "SYS_C007014" PRIMARY KEY ("ID");

ALTER TABLE "SYSTEM"."ROLES_USUARIOS_APLICATIVO" ADD CONSTRAINT "USUARIO_FK_APLICATIVO" FOREIGN KEY ("USUARIO")
	REFERENCES "SYSTEM"."USUARIOS_APLICATIVO" ("USUARIO")
	ON DELETE RESTRICT
	ON UPDATE CASCADE;

