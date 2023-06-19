<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform
" version="1.0">
	<xsl:output method="xml" indent="yes" />

	<xsl:template match="/auftrag">
		<html>
			<h1>Summenliste</h1>
			<table>
				<xsl:apply-templates select="betrag" />
			</table>
		</html>
	</xsl:template>

	<xsl:template match="betrag">
		<tr>
			<td>Betrag:</td><td>
				<xsl:value-of select="betrag" />
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>