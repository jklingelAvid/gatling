/*
 * Copyright 2011-2021 GatlingCorp (https://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.gatling.core.javaapi;

import scala.Tuple2;
import scala.collection.immutable.Seq;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.gatling.core.javaapi.internal.ScalaHelpers.toScalaSeq;

public final class RandomSwitchPossibility {

  private final double weight;
  private final ChainBuilder chain;

  public RandomSwitchPossibility(double weight, ChainBuilder chain) {
    this.weight = weight;
    this.chain = chain;
  }

  private Tuple2<Object, io.gatling.core.structure.ChainBuilder> asScala() {
    return new Tuple2<>(weight, chain.wrapped);
  }

  public static Seq<Tuple2<Object, io.gatling.core.structure.ChainBuilder>> asScala(Stream<RandomSwitchPossibility> possibilities) {
    return toScalaSeq(possibilities.map(RandomSwitchPossibility::asScala).collect(Collectors.toList()));
  }
}