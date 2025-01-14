/*******************************************************************************
 * Copyright (c) 2020 Eclipse RDF4J contributors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/
package org.eclipse.rdf4j.sail.shacl.ast.planNodes;

public class PlanNodeHelper {

	public static PlanNode handleSorting(PlanNode child, PlanNode parent) {
		return handleSorting(child.requiresSorted(), parent);
	}

	public static PlanNode handleSorting(boolean requiresSorted, PlanNode parent) {
		if (requiresSorted) {
			if (!parent.producesSorted()) {
				parent = new Sort(parent);
			}
		}
		return parent;
	}

}
