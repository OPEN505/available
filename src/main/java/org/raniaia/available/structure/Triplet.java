package org.raniaia.available.structure;

/*
 * Copyright (C) 2020 Tiansheng All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Creates on 2020/4/9.
 */

/**
 * 三元组
 * @author tiansheng
 */
public class Triplet<V1,V2,V3> {

	private V1 v1;

	private V2 v2;

	private V3 v3;

	public V1 getValue0(){return this.v1;}

	public V2 getValue1(){return this.v2;}

	public V3 getValue2(){return this.v3;}

}
